package com.ittraining.main.config;

import com.ittraining.main.dao.AdresseRepository;
import com.ittraining.main.dao.ClientRepository;
import com.ittraining.main.dao.DomaineRepository;
import com.ittraining.main.dao.EmployeRepository;
import com.ittraining.main.dao.FormateurRepository;
import com.ittraining.main.dao.FormationRepository;
import com.ittraining.main.dao.PrerequisRepository;
import com.ittraining.main.dao.RoleRepository;
import com.ittraining.main.dao.SessionRepository;
import com.ittraining.main.dao.ThemeRepository;
import com.ittraining.main.models.Client;
import com.ittraining.main.models.Domaine;
import com.ittraining.main.models.Employe;
import com.ittraining.main.models.Formation;
import com.ittraining.main.models.Prerequis;
import com.ittraining.main.models.Role;
import com.ittraining.main.models.Theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerConfig implements CommandLineRunner {

	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private DomaineRepository domaineRepository;
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@Autowired
	private FormateurRepository formateurRepository;
	
	@Autowired
	private PrerequisRepository prerequisRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Override
	public void run(String... args) throws Exception {


		Client c1 = new Client("wick", "john", "wick", "wick@mail.com", null);
		Client c2 = new Client("travolta", "john", "travolta", "john@mail.com", null);
		clientRepository.save(c1);
		clientRepository.save(c2);
		Domaine i1 = new Domaine("informatique", null);
		domaineRepository.save(i1);
		Theme t1 = new Theme("Langages & Développement", i1);
		themeRepository.save(t1);
		Theme t2 = new Theme("Base de données", i1);
		themeRepository.save(t2);
		Employe e1 = new Employe("Hamida", "Aicha", "aicha", "hamida.aicha@it-training.com", null);
		Employe e2 = new Employe("Di Lorenzo", "Lucas", "lucas", "dilorenzo.lucas@it-training.com", null);
		Employe e3 = new Employe("Heuillet", "Cecile", "cecile", "heuillet.cecile@it-training.com", null);
		employeRepository.save(e1);
		employeRepository.save(e2);
		employeRepository.save(e3);
//		Formation f2 = new Formation();
//		formationRepository.save(f2);
//		Prerequis p1 = new Prerequis("qcm1", false, f2);
//		prerequisRepository.save(p1);
		Formation f1 = new Formation(i1, t1, 5390.00, null, null, "Découvrir le langage de programmation Java et disposer des bases nécessaires au développement d'applications Web Java dans des environnements éditeur (WebSphere, WebLogic) comme Open Source.",
				"Parce que les applications développées en Java sont très facilement portables sur différents systèmes d'exploitation tels que Windows, Mac OS, UNIX ou encore Linux, ce langage orienté Objet qui reprend en grande partie la syntaxe du C++ est toujours très prisé par les équipes de développement. Ce cursus métier vise à faire découvrir aux participants comment bien programmer en Java, et à les rendre autonomes pour développer des applications Web avec Angular, TypeScript et Bootstrap. A l'issue de ce parcours de 14 jours, les participants disposeront des compétences nécessaires prendre en charge des projets de développement d'applications web en Java.",
				"Objectif : découvrir le langage de programmation Java et disposer des bases nécessaires au développement d'applications Web Java dans des environnements éditeur (WebSphere, WebLogic) comme Open Source. Présentation de l'écosystème java : composants techniques de java (JDK) et principales apis, les outils java : JavaDoc, jar et co. Panorama des principaux ide : Eclipse, Netbeans et Intellij. L'ide Eclipse. Les bases du langage : la syntaxe. Les concepts orientes-objet en java. Gestion des erreurs avec les exceptions. Bibliothèques standards (collection, date, entrées/sorties). Accès aux Systèmes de Gestion de Bases de Données avec JDBC. Fichiers de propriétés et l'api d'internationalisation (i18n). API pour les fichiers de logs. Améliorer la qualité d'une application grâce aux tests unitaires. Programmation fonctionnelle et lambda expressions. Introduction aux nouveautés java 9.",
				e1, "Développeur Java JEE", 98);
		formationRepository.save(f1);
		Formation f2 = new Formation(i1, t1, 8860.00, null, null, "Disposer des connaissances et compétences nécessaires pour identifier et collecter des données et s'assurer de leur qualité et de leur alignement sur les besoins et usages métiers de l'entreprise.",
				"Les entreprises collectent aujourd'hui de tels volumes d'informations que leur exploitation avec des méthodes traditionnelles est devenue impossible. Pourtant, ces informations sont des mines d'or ! Mais encore faut-il savoir les traiter, les analyser et en tirer la substantifique moelle. C'est précisément la mission qui incombe au Data Scientist qui en imaginant de nouveaux modèles et en utilisant de nouveaux outils va donner du sens aux données et en extraire de la valeur pour aider l'entreprise à prendre des décisions. A la fois spécialiste des données, des chiffres, des statistiques, des outils informatiques et grand connaisseur du secteur pour lequel il analyse des données, le Data Scientist est aussi un créatif qui doit savoir utiliser les outils de restitution de données pour restituer de façon claire et convaincante le résultat de ses analyses.",
				"Objectif : Disposer des connaissances et compétences nécessaires pour identifier et collecter des données et s'assurer de leur qualité et de leur alignement sur les besoins et usages métiers de l'entreprise. Les nouvelles frontières du Big Data (introduction) : immersion, l'approche des 4 Vs, cas d'usages du Big Data, technologies, architecture, master-less vs master-slaves, stockage, Machine Learning, Data Scientist et Big Data, compétences, la vision du Gartner, valeur ajoutée du Big Data. La collecte des données : typologie des sources, les données non structurées, typologie 3V des sources, les données ouvertes (Open Data), nouveau paradigme de l'ETL à l'ELT, le concept du Data Lake, les API de réseaux sociaux. Le calcul massivement parallèle : genèse et étapes clés, Hadoop, HDFS, MapReduce, Apache PIG et Apache HIVE, comparatif des 3 approches, limitations de MapReduce, moteur d'exécution Apache TEZ, la rupture Apache SPARK, Hive in Memory (LLAP), Big Deep Learning. Les nouvelles formes de stockage : enjeux, le 'théorème' CAP, nouveaux standards : ACID => BASE, panorama des bases de données NoSQL, bases de données Clé-Valeur, bases de données Document, bases de données colonnes, bases de données Graphes. Le Big Data Analytics (fondamentaux) : analyse de cas concrets, que peuvent apprendre les machines ? , les différentes expériences (E), l'apprentissage, choisir un algorithme d'apprentissage machine, anatomie d'un modèle d'apprentissage automatique, les librairies de machine learning standards et Deep Learning, les plates-formes de Data Science. Le Big Data Analytics (écosystème SPARK) : les différents modes de travail, les 3 systèmes de gestion de cluster, modes d'écriture des commandes Spark, machine learning avec Spark , travail sur les variables prédictives, la classification et la régression. Traitement en flux du Big Data (​streaming​ ) : architectures types de traitement de Streams Big Data, Apache NIFI, Apache KAFKA, articulation NIFI et KAFKA, Apache STORM, articulation KAFKA et STORM, comparatif STORM/SPARK. Déploiement d'un projet Big Data : Cloud Computing , 5 caractéristiques essentielles, 3 modèles de services, modes (SaaS , PaaS, IaaS), Cloud Privé virtuel (VPC), focus AWS, GCP et Azure. Hadoop écosystème et distributions : écosystème, fonctions coeurs, HDFS, Map Reduce, infrastructure YARN, distributions Hadoop, focus Cloudera, Focus Hortonworks. Architecture de traitement Big Data : traitement de données par lots, traitement de données en flux, modèles d'architecture de traitement de données Big Data, l'heure du choix. La gouvernance des données Big Data : outils de gouvernance Big Data, les 3 piliers, le management de la qualité des données, le management des métadonnées Big Data, management de la sécurité, de la conformité et la confidentialité.",
				e2, "Data Scientist", 126);
		formationRepository.save(f2);
		Formation f3 = new Formation(i1, t1, 11320.00, null, null, "Découvrir les techniques de base du hacking et comprendre comment les mécanismes et outils de sécurité peuvent constituer un premier rempart.",
				"Il ne se passe pas une semaine sans que les médias n'évoquent des actes de piratage touchant de grandes entreprises, des acteurs de la nouvelle économie ou ... des états. Vol d'informations stratégiques, de fichiers clients, détournements de fonds bancaires, neutralisation de serveurs web... Et bien sûr, il est facile de comprendre qu'au-delà du préjudice financier, il y a toujours un important préjudice d'image. Il n'est donc pas surprenant que de nombreuses entreprises cherchent à se prémunir de ce type de risques. Pour autant, elles peinent souvent à trouver les profils capables de sécuriser efficacement leur SI et de mettre en échec les tentatives d'intrusion des (hackers). A l'issue de ce cursus de 23 jours, les participants disposeront précisément des connaissances et compétences nécessaires à l'atteinte de ces objectifs.",
				"Objectif : découvrir les techniques de base du hacking et comprendre comment les mécanismes et outils de sécurité peuvent constituer un premier rempart. Les fondamentaux de la sécurité des réseaux : prise d'informations à distance sur des réseaux d'entreprise et des systèmes distants, consultation d'informations publiques, localisation un système cible, énumération des services actifs. Les attaques à distance : intrusion à distance des postes clients par exploitation des vulnérabilités sur les services distants, et prise de contrôle des postes utilisateurs par troyen, authentification par brute force, recherche et exploitation de vulnérabilités sur un système cible, prise de contrôle à distance. Les attaques systèmes : outrepasser l'authentification et/ou surveiller l'utilisateur suite à une intrusion, attaque du Bios, cracking de mot de passe et espionnage du système. Sécuriser le système : les outils de base permettant d'assurer le minimum de sécurité à un S.I., la cryptographie, le chiffrement des données, la détection d'activité anormale, le rôle de la base de registre, le firewalling, l'anonymat.",
				e3, "Expert en cybersécurité", 161);
		formationRepository.save(f3);
		
		Role r1 = new Role("Admin", null);
		roleRepository.save(r1);
		Role r2 = new Role("Employe", null);
		roleRepository.save(r2);
	}

}
