package com.ittraining.main.security.jtw;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittraining.main.security.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

// La classe JwtAuthTokenFilter va filtrer les accès selon les valeurs contenues dans le jeton envoyé.
@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtProvider tokenProvider;
	
	@Autowired 
	private UserDetailsServiceImpl userDetailsService;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

	// Ce que nous faisons à l'intérieur de doFilterInternal() :

	//- obtenir JWT à partir de l'en-tête d'autorisation (en supprimant le préfixe Bearer)
	//- si la demande a JWT, validez-la, analysez le nom d'utilisateur à partir de celui-ci
	//– à partir du nom d'utilisateur, obtenez UserDetails pour créer un objet d'authentification
	//– définissez les UserDetails actuels dans SecurityContext à l'aide de la méthode setAuthentication(authentication).

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String jwt = getJwt(request);
			if(jwt != null && tokenProvider.validateJwtToken(jwt)) {
				
				String username = tokenProvider.getUserNameFromJwtToken(jwt);
				
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authentication);				
			}
		} catch (Exception e) {
			logger.error("can Not set User authentication -> Message : {}", e);
		}
		filterChain.doFilter(request, response);		
	}

	private String getJwt(HttpServletRequest request) {

		String authHeader = request.getHeader("Authorization");

		if(authHeader != null && authHeader.startsWith("Bearer")) {
			return authHeader.replace("Bearer", "");
		}
		return null;
	}

}