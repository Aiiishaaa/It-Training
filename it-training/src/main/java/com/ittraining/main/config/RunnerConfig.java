package com.ittraining.main.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ittraining.main.dao.AdresseRepository;
import com.ittraining.main.dao.DomaineRepository;
import com.ittraining.main.dao.FormateurRepository;
import com.ittraining.main.dao.FormationRepository;
import com.ittraining.main.dao.PrerequisRepository;
import com.ittraining.main.dao.RoleRepository;
import com.ittraining.main.dao.SessionRepository;
import com.ittraining.main.dao.ThemeRepository;
import com.ittraining.main.dao.UserRepository;
import com.ittraining.main.models.Adresse;
import com.ittraining.main.models.Domaine;
import com.ittraining.main.models.Formateur;
import com.ittraining.main.models.Formation;
import com.ittraining.main.models.Prerequis;
import com.ittraining.main.models.Role;
import com.ittraining.main.models.RoleName;
import com.ittraining.main.models.Session;
import com.ittraining.main.models.Theme;
import com.ittraining.main.models.User;

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
	private DomaineRepository domaineRepository;

	@Autowired
	private ThemeRepository themeRepository;

	@Autowired
	private FormateurRepository formateurRepository;

	@Autowired
	private PrerequisRepository prerequisRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	SessionRepository sessionRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User("Taylor", "John", "john@mail.com", "taylor");
		User u2 = new User("Monceau", "Rose", "rose@mail.com", "monceau");
		User u3 = new User("Beanbean", "Tony", "tony@mail.com", "beanbean");
		User u4 = new User("Natoni", "Maya", "maya@mail.com", "natoni");
		User u5 = new User("Gronchon", "Richard", "richard@mail.com", "gronchon");
		User u6 = new User("Bellami", "Louise", "louise@mail.com", "bellami");
		User u7 = new User("Hamida", "Aicha", "Aicha", "hamida.aicha@it-training.com", "12345678", null, "06 55 49 33 14");
		User u8 = new User("Di Lorenzo", "Lucas", "Lucas", "dilorenzo.lucas@it-training.com", "12345678", null, "06 37 31 32 34");
		User u9 = new User("Heuillet", "Cecile", "Cecile", "heuillet.cecile@it-training.com", "12345678", null, "06 78 64 12 99");
		userRepository.save(u7);
		userRepository.save(u8);
		userRepository.save(u9);
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		userRepository.save(u4);
		userRepository.save(u5);
		userRepository.save(u6);

		List<User> clientsSession1 = new ArrayList<>();
		clientsSession1.add(u1);
		clientsSession1.add(u2);
		List<User> clientsSession2 = new ArrayList<>();
		clientsSession2.add(u3);
		clientsSession2.add(u5);
		List<User> clientsSession3 = new ArrayList<>();
		clientsSession3.add(u2);
		clientsSession3.add(u4);
		clientsSession3.add(u6);

		Domaine d1 = new Domaine("Informatique", null, null);
		domaineRepository.save(d1);
		Domaine d2 = new Domaine("Management & soft skills", null, null);
		domaineRepository.save(d2);

		Theme t1 = new Theme("Langages & Développement", d1);
		themeRepository.save(t1);
		Theme t2 = new Theme("Base de données", d1);
		themeRepository.save(t2);
		Theme t3 = new Theme("Gestion de projets", d2);
		themeRepository.save(t3);
		Theme t4 = new Theme("Communication", d2);
		themeRepository.save(t4);

		List<Theme> themesDom1 = new ArrayList<>();
		themesDom1.add(t1);
		themesDom1.add(t2);
		d1.setThemes(themesDom1);
		domaineRepository.save(d1);

		List<Theme> themesDom2 = new ArrayList<>();
		themesDom2.add(t3);
		themesDom2.add(t4);
		d2.setThemes(themesDom2);
		domaineRepository.save(d2);



		RoleName rn1 = RoleName.ROLE_EMPLOYE;
		RoleName rn2 = RoleName.ROLE_ADMIN;
		RoleName rn3 = RoleName.ROLE_CLIENT;
		Role r1 = new Role(rn1, null);
		Role r2 = new Role(rn2, null);
		Role r3 = new Role(rn3, null);
		roleRepository.save(r1);
		roleRepository.save(r2);
		roleRepository.save(r3);
		Set<Role> roles1 = new HashSet<Role>();
		Set<Role> roles2 = new HashSet<Role>();
		Set<Role> roles3 = new HashSet<Role>();
		roles1.add(r1);
		roles1.add(r2);
		roles2.add(r1);
		roles3.add(r3);

		u7.setRoles(roles1);
		u8.setRoles(roles2);
		u9.setRoles(roles2);
		u1.setRoles(roles3);
		u2.setRoles(roles3);
		u3.setRoles(roles3);
		u4.setRoles(roles3);
		u5.setRoles(roles3);
		u6.setRoles(roles3);
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		userRepository.save(u4);
		userRepository.save(u5);
		userRepository.save(u6);
		userRepository.save(u7);
		userRepository.save(u8);
		userRepository.save(u9);

		Formateur fo1 = new Formateur("Boulgour", "Roger", "boulgour.roger@it-training.com", "12345678", null);
		Formateur fo2 = new Formateur("Pates", "Malika", "pates.malika@it-training.com", "12345678", null);
		Formateur fo3 = new Formateur("Williams", "Bobi", "matui.damien@it-training.com", "12345678", null);
		formateurRepository.save(fo1);
		formateurRepository.save(fo2);
		formateurRepository.save(fo3);

		Adresse a1 = new Adresse(154, "Rue due Paradis", "13006", "Marseille", null);
		Adresse a2 = new Adresse(400, "Avenue Roumanille", "06906", "Sophia-Antipolis", null);
		Adresse a3 = new Adresse(6, "Chemin du Dôme", "75012", "Paris", null);
		adresseRepository.save(a1);
		adresseRepository.save(a2);
		adresseRepository.save(a3);

		Formation f1 = new Formation(d1, t1, 5390.00, null, null, "Découvrir le langage de programmation Java et disposer des bases nécessaires au développement d'applications Web Java dans des environnements éditeur (WebSphere, WebLogic) comme Open Source.",
				"Parce que les applications développées en Java sont très facilement portables sur différents systèmes d'exploitation tels que Windows, Mac OS, UNIX ou encore Linux, ce langage orienté Objet qui reprend en grande partie la syntaxe du C++ est toujours très prisé par les équipes de développement. Ce cursus métier vise à faire découvrir aux participants comment bien programmer en Java, et à les rendre autonomes pour développer des applications Web avec Angular, TypeScript et Bootstrap. A l'issue de ce parcours de 14 jours, les participants disposeront des compétences nécessaires prendre en charge des projets de développement d'applications web en Java.",
				"Objectif : découvrir le langage de programmation Java et disposer des bases nécessaires au développement d'applications Web Java dans des environnements éditeur (WebSphere, WebLogic) comme Open Source. Présentation de l'écosystème java : composants techniques de java (JDK) et principales apis, les outils java : JavaDoc, jar et co. Panorama des principaux ide : Eclipse, Netbeans et Intellij. L'ide Eclipse. Les bases du langage : la syntaxe. Les concepts orientes-objet en java. Gestion des erreurs avec les exceptions. Bibliothèques standards (collection, date, entrées/sorties). Accès aux Systèmes de Gestion de Bases de Données avec JDBC. Fichiers de propriétés et l'api d'internationalisation (i18n). API pour les fichiers de logs. Améliorer la qualité d'une application grâce aux tests unitaires. Programmation fonctionnelle et lambda expressions. Introduction aux nouveautés java 9.",
				u7, "Développeur Java JEE", 98, "/assets/images/work-6.jpg");
		formationRepository.save(f1);
		Formation f2 = new Formation(d1, t2, 8860.00, null, null, "Disposer des connaissances et compétences nécessaires pour identifier et collecter des données et s'assurer de leur qualité et de leur alignement sur les besoins et usages métiers de l'entreprise.",
				"Les entreprises collectent aujourd'hui de tels volumes d'informations que leur exploitation avec des méthodes traditionnelles est devenue impossible. Pourtant, ces informations sont des mines d'or ! Mais encore faut-il savoir les traiter, les analyser et en tirer la substantifique moelle. C'est précisément la mission qui incombe au Data Scientist qui en imaginant de nouveaux modèles et en utilisant de nouveaux outils va donner du sens aux données et en extraire de la valeur pour aider l'entreprise à prendre des décisions. A la fois spécialiste des données, des chiffres, des statistiques, des outils informatiques et grand connaisseur du secteur pour lequel il analyse des données, le Data Scientist est aussi un créatif qui doit savoir utiliser les outils de restitution de données pour restituer de façon claire et convaincante le résultat de ses analyses.",
				"Objectif : Disposer des connaissances et compétences nécessaires pour identifier et collecter des données et s'assurer de leur qualité et de leur alignement sur les besoins et usages métiers de l'entreprise. Les nouvelles frontières du Big Data (introduction) : immersion, l'approche des 4 Vs, cas d'usages du Big Data, technologies, architecture, master-less vs master-slaves, stockage, Machine Learning, Data Scientist et Big Data, compétences, la vision du Gartner, valeur ajoutée du Big Data. La collecte des données : typologie des sources, les données non structurées, typologie 3V des sources, les données ouvertes (Open Data), nouveau paradigme de l'ETL à l'ELT, le concept du Data Lake, les API de réseaux sociaux. Le calcul massivement parallèle : genèse et étapes clés, Hadoop, HDFS, MapReduce, Apache PIG et Apache HIVE, comparatif des 3 approches, limitations de MapReduce, moteur d'exécution Apache TEZ, la rupture Apache SPARK, Hive in Memory (LLAP), Big Deep Learning. Les nouvelles formes de stockage : enjeux, le 'théorème' CAP, nouveaux standards : ACID => BASE, panorama des bases de données NoSQL, bases de données Clé-Valeur, bases de données Document, bases de données colonnes, bases de données Graphes. Le Big Data Analytics (fondamentaux) : analyse de cas concrets, que peuvent apprendre les machines ? , les différentes expériences (E), l'apprentissage, choisir un algorithme d'apprentissage machine, anatomie d'un modèle d'apprentissage automatique, les librairies de machine learning standards et Deep Learning, les plates-formes de Data Science. Le Big Data Analytics (écosystème SPARK) : les différents modes de travail, les 3 systèmes de gestion de cluster, modes d'écriture des commandes Spark, machine learning avec Spark , travail sur les variables prédictives, la classification et la régression. Traitement en flux du Big Data (​streaming​ ) : architectures types de traitement de Streams Big Data, Apache NIFI, Apache KAFKA, articulation NIFI et KAFKA, Apache STORM, articulation KAFKA et STORM, comparatif STORM/SPARK. Déploiement d'un projet Big Data : Cloud Computing , 5 caractéristiques essentielles, 3 modèles de services, modes (SaaS , PaaS, IaaS), Cloud Privé virtuel (VPC), focus AWS, GCP et Azure. Hadoop écosystème et distributions : écosystème, fonctions coeurs, HDFS, Map Reduce, infrastructure YARN, distributions Hadoop, focus Cloudera, Focus Hortonworks. Architecture de traitement Big Data : traitement de données par lots, traitement de données en flux, modèles d'architecture de traitement de données Big Data, l'heure du choix. La gouvernance des données Big Data : outils de gouvernance Big Data, les 3 piliers, le management de la qualité des données, le management des métadonnées Big Data, management de la sécurité, de la conformité et la confidentialité.",
				u8, "Data Scientist", 126, "/assets/images/work-2.jpg");
		formationRepository.save(f2);
		Formation f3 = new Formation(d1, t2, 11320.00, null, null, "Découvrir les techniques de base du hacking et comprendre comment les mécanismes et outils de sécurité peuvent constituer un premier rempart.",
				"Il ne se passe pas une semaine sans que les médias n'évoquent des actes de piratage touchant de grandes entreprises, des acteurs de la nouvelle économie ou ... des états. Vol d'informations stratégiques, de fichiers clients, détournements de fonds bancaires, neutralisation de serveurs web... Et bien sûr, il est facile de comprendre qu'au-delà du préjudice financier, il y a toujours un important préjudice d'image. Il n'est donc pas surprenant que de nombreuses entreprises cherchent à se prémunir de ce type de risques. Pour autant, elles peinent souvent à trouver les profils capables de sécuriser efficacement leur SI et de mettre en échec les tentatives d'intrusion des (hackers). A l'issue de ce cursus de 23 jours, les participants disposeront précisément des connaissances et compétences nécessaires à l'atteinte de ces objectifs.",
				"Objectif : découvrir les techniques de base du hacking et comprendre comment les mécanismes et outils de sécurité peuvent constituer un premier rempart. Les fondamentaux de la sécurité des réseaux : prise d'informations à distance sur des réseaux d'entreprise et des systèmes distants, consultation d'informations publiques, localisation un système cible, énumération des services actifs. Les attaques à distance : intrusion à distance des postes clients par exploitation des vulnérabilités sur les services distants, et prise de contrôle des postes utilisateurs par troyen, authentification par brute force, recherche et exploitation de vulnérabilités sur un système cible, prise de contrôle à distance. Les attaques systèmes : outrepasser l'authentification et/ou surveiller l'utilisateur suite à une intrusion, attaque du Bios, cracking de mot de passe et espionnage du système. Sécuriser le système : les outils de base permettant d'assurer le minimum de sécurité à un S.I., la cryptographie, le chiffrement des données, la détection d'activité anormale, le rôle de la base de registre, le firewalling, l'anonymat.",
				u9, "Expert en cybersécurité", 161, "/assets/images/image_1.jpg");
		formationRepository.save(f3);
		Formation f4 = new Formation(d1, t1, 6970.00, null, null, "Acquérir la connaissance des commandes fondamentales des systèmes d'exploitation Linux et développer un premier niveau d'autonomie en vue de la prise en main d'un système.",
				"Il ne se passe pas une semaine sans que les médias n'évoquent des actes de piratage touchant de grandes entreprises, des acteurs de la nouvelle économie ou ... des états. Vol d'informations stratégiques, de fichiers clients, détournements de fonds bancaires, neutralisation de serveurs web... Et bien sûr, il est facile de comprendre qu'au-delà du préjudice financier, il y a toujours un important préjudice d'image. Il n'est donc pas surprenant que de nombreuses entreprises cherchent à se prémunir de ce type de risques. Pour autant, elles peinent souvent à trouver les profils capables de sécuriser efficacement leur SI et de mettre en échec les tentatives d'intrusion des (hackers). A l'issue de ce cursus de 23 jours, les participants disposeront précisément des connaissances et compétences nécessaires à l'atteinte de ces objectifs.",
				"Objectif : acquérir la connaissance des commandes fondamentales des systèmes d'exploitation Linux et développer un premier niveau d'autonomie en vue de la prise en main d'un système. Introduction. Une session : démarrage, commandes et documentation. Les fichiers et les répertoires : arborescence, chemins, commandes de gestion de fichiers et de répertoires. Le Shell : présentation, réalisation d'un script élémentaire. Les droits : gestion des droits et des groupes. L'impression : principes et commandes. Les filtres : présentation, commandes grep, cut, sed, sort, more et pg. La sauvegarde : commandes tar et cpio. Les outils de communication : commandes write, talk et mail. Les liens : commandes, liens symboliques. La gestion des processus : commandes kill, ps, gestion des travaux. L'éditeur vi : commandes, modes et paramétrage de vi. Unix et les réseaux : comprendre TCP/IP, connexion à distance, transfert de fichiers.",
				u7, "Administrateur Linux", 119, "/assets/images/work-4.jpg");
		formationRepository.save(f4);
		Formation f5 = new Formation(d2, t3, 1650.00, null, null, "La formation Management et gestion de projets opérationnels vous permettra d'acquérir les compétences pour piloter les projets, manager les équipes, tenir les délais et budgets.",
				"Objectifs pédagogiques / Compétences visées : Conduire une réunion de conception de projet. Concevoir un projet à mettre en oeuvre dans votre entreprise. Conduire une équipe projets de manière assertive, pour contribuer ensemble à la mise en place du projet. Conduire les réunions projets. Etablir un plan d'action (organigramme des tâches, ressources...). Conduire les projets. Composer et conduire vos équipes. Préparer et partager l'avancement du projet. Etablir les budgets. Anticiper et analyser les risques. Etablir une culture d'entreprise. Créer une base de données multi-projets.",
				"Introduction. Présentation de chacun. Attentes et objectifs visés de chaque participant. Présentation de la formation. Suis-je crédible ? Vendre sa solution. Le management transverse. La communication avec les équipes. Les 25 erreurs à éviter. Les motivations d'adhésion au projet. La résistance aux changements. Les leviers d'influence. Comment fédérer mon équipe projets ? Les différences culturelles. L'éloignement géographique. Les hiérarchies différentes. Les différences comportementales. Les règles d'un projet. Les conflits et arbitrages. La charte projets. Les luttes de pouvoir internes au projet. Les enjeux politiques. Communiquer sur le projet. Importance de la communication. Par où commencer ? Management des projets. Définition du projet. Management, gestion et direction du projet. Les facteurs de succès des projets. La gestion du risque. La note de lancement du projet. Importance d'une bonne préparation. La note de lancement du projet. La réunion de lancement. Les différents types d'organisation. Constituer son équipe projet. Les différents acteurs. Composition de l'équipe. Conduire les réunions de projets. La conduite de réunion. Les réunions de projets. Les revues de projets. Les comités de pilotage. Quelle organisation pour mon projet ? La structuration du projet. L'organigramme des tâches. L'organigramme des ressources. L'organigramme des coûts. Le calendrier des objectifs. Les différentes phases d'un projet. La mise en place des jalons. La planification de projets. Les plannings (GANTT et PERT). Le chemin critique. L'avancement des travaux. Coordination et suivi. Importance de la coordination. Les outils de suivi. Les comptes-rendus. Le tableau de bord. La gestion multi-projets. Identification et positionnement des risques du projet. Identification des risques. Typologie des risques. Spécificité des risques. Méthodes d'identification. Configuration. Facteurs de risque. Culture projet dans l'entreprise. Kit de procédures. Base de données multi-projets. Révision des points abordés dans le programme. Synthèse de la session. Réflexion sur les applications concrètes que chacun peut mettre en oeuvre dans son environnement. Conseils personnalisés donnés par l'animateur à chaque participant. Bilan oral et évaluation à chaud.",
				u9, "Management et gestion de projets opérationnels", 24, "/assets/images/work-5.jpg");
		formationRepository.save(f5);
		Formation f6 = new Formation(d2, t4, 2860.00, null, null, "Développer vos compétences en communication interpersonnelle et en option préparer la certification en communication interpersonnelle.",
				"Objectifs pédagogiques / Compétences visées : Conduire une réunion de conception de projet. Concevoir un projet à mettre en oeuvre dans votre entreprise. Conduire une équipe projets de manière assertive, pour contribuer ensemble à la mise en place du projet. Conduire les réunions projets. Etablir un plan d'action (organigramme des tâches, ressources...). Conduire les projets. Composer et conduire vos équipes. Préparer et partager l'avancement du projet. Etablir les budgets. Anticiper et analyser les risques. Etablir une culture d'entreprise. Créer une base de données multi-projets.",
				"Cette formation est animée par un intervenant certifié auprès de KCF (Kahler Communication France). A l'issue de la formation, passage de la certification :  Examen en ligne avec le simulateur. Le candidat devra avoir obtenu un score de 80% minimum. La réussite de l'examen en ligne est un prérequis pour passer l'examen oral. Examen oral par Skype avec un certificateur agréé. Le certificateur propose au candidat 3x3 interactions par type de personnalité avec une exigence de 2 interventions sur 3 réussies. En cas d'échec, le candidat peut repasser 2 fois l'examen écrit et oral sans surcoût, uniquement sur les épreuves sur lesquelles il a échoué. Pour plus d'informations concernant les tarifs INTRA, contactez votre conseiller formation.",
				u8, "Individualisez votre communication", 40, "/assets/images/image_2.jpg");
		formationRepository.save(f6);
		Formation f7 = new Formation(d2, t4, 1785.00, null, null, "Gestion du stress, gestion des priorités, capacité d'écoute active, esprit créatif… font partie intégrante des « soft-skills ». Elles ne dépendent pas d'un savoir-faire, mais plutôt d'un savoir-être.",
				"L'enjeu pour les entreprises est de recruter des collaborateurs capables de s'adapter dans un environnement mouvant, et d'apporter des innovations permettant de se démarquer de la concurrence. Les soft-skills sont de plus en plus cherchées par les employeurs. C'est pourquoi il est nécessaire de les développer au cours de sa carrière. Compléter vos savoir-faire métiers par la maîtrise des savoir-être aujourd'hui incontournables pour être un professionnel efficace. Identifier vos besoins, vos limites, vos croyances négatives, en termes de comportements au travail. Identifier les principales dimensions des compétences comportementales et développer les éléments fondamentaux de ces attitudes : la relation positive, la maîtrise temporelle, l'attitude résiliente. Améliorer votre rapport au travail et au collectif de travail Retrouver de la stabilité et des certitudes à travers une meilleure vision de vos forces et de vos faiblesses.",
				"Introduction. Présentation de chacun. Attentes et objectifs visés de chaque participant. Présentation de la formation. Les nouveaux contextes de travail. Incertitude, instabilité, complexité, ambiguïté, paradoxes. Les points de tension, le temps, la décision, les modes d'organisation. Les effets négatifs de la perte de contrôle : stress, usure, fatigue, démotivation. La digitalisation et les nouvelles organisations. Faire le point sur sa cartographie compétences. Les 3 dimensions des soft skills. Evaluer ses besoins, ses points faibles, points forts. Evaluer ses modèles, ses styles d'intervention, de communication, de relation. Evaluer son leadership. Des besoins en compétence. Développer des relations positives. Communication. Gagner en aisance relationnelle. Identifier ses modèles et ses styles personnels. Développer les postures et les positionnements efficaces. Pratiquer la communication inclusive, le nudge, l'influence douce. Des clés de la communication non violente. Développer des comportements stables et positifs face aux oppositions, aux confrontations, aux différences. Intelligence émotionnelle. Approfondir la connaissance des émotions et leurs rôles dans les relations interpersonnelles. Percevoir que jugements, opinions et ressentis ne sont pas des faits. Développer son ouverture émotionnelle. Inhibition, réaction, réponse : gérer ses émotions. Identifier les mécanismes et ses propres sources de stress. Développer ses leviers d'adaptation et de résilience. Se placer dans une dynamique positive. Se donner toutes les chances de cultiver sa confiance en soi. Mesurer l'impact de l'éthique et des valeurs sur l'efficacité au quotidien. Mettre en œuvre des comportements stimulants. Comprendre les dynamiques d'engagement, d'implication. Stabiliser sa relation au temps. Mieux gérer son temps. Mieux comprendre son rapport au temps. Développer des comportements stables et une organisation structurée. Mieux s'organiser personnellement et avec les autres. Lutter contre les urgences, gérer les priorités. S'outiller en mode digital. Utiliser les outils digitaux de travail et de coopération. Gérer le rapport vie privée et vie professionnelle. Mieux vivre les transitions. Booster sa créativité. Création, innovation, rupture, comportements novateurs. Comprendre les leviers de la créativité. Sortir des limitations, points de vue et croyances personnelles. Développer des solutions, agir dans une logique de solutions. Maintenir ses capacités décisionnelles dans la pression. Agir et décider sous pression. Construire dans l'incertain, proposer, trouver des réponses, résoudre les problèmes. Développer des comportements stables, cadrés et rassurants. Exemples de travaux pratiques (à titre indicatif).",
				u9, "Développez vos compétences comportementales", 21, "/assets/images/image_4.jpg");
		formationRepository.save(f7);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Session s1 = new Session(LocalDate.parse("2023-05-15", formatter), LocalDate.parse("2023-08-05", formatter), f1, fo2, a2, null);
		Session s2 = new Session(LocalDate.parse("2022-09-15", formatter), LocalDate.parse("2022-12-05", formatter), f1, fo3, a1, null);
		Session s3 = new Session(LocalDate.parse("2022-09-15", formatter), LocalDate.parse("2022-12-05", formatter), f1, fo2, a2, clientsSession3);
		Session s4 = new Session(LocalDate.parse("2022-09-19", formatter), LocalDate.parse("2022-09-21", formatter), f6, fo2, a3, clientsSession1);
		Session s5 = new Session(LocalDate.parse("2022-10-03", formatter), LocalDate.parse("2022-10-07", formatter), f5, fo2, a3, clientsSession2);
		Session s6 = new Session(LocalDate.parse("2023-01-09", formatter), LocalDate.parse("2023-02-01", formatter), f1, fo3, a1, null);
		sessionRepository.save(s1);
		sessionRepository.save(s2);
		sessionRepository.save(s3);
		sessionRepository.save(s4);
		sessionRepository.save(s5);
		sessionRepository.save(s6);

		Prerequis p1 = new Prerequis("qcm1", false, f2);
		Prerequis p2 = new Prerequis("qcm2", false, f5);
		Prerequis p3 = new Prerequis("qcm1", false, f1);
		Prerequis p4 = new Prerequis("qcm2", false, f6);
		Prerequis p5 = new Prerequis("qcm1", false, f4);
		Prerequis p6 = new Prerequis("qcm2", false, f3);
		prerequisRepository.save(p1);
		prerequisRepository.save(p2);
		prerequisRepository.save(p3);
		prerequisRepository.save(p4);
		prerequisRepository.save(p5);
		prerequisRepository.save(p6);

	}

}
