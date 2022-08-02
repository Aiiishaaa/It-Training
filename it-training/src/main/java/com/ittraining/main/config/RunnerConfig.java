package com.ittraining.main.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import com.ittraining.main.models.Adresse;
import com.ittraining.main.models.Client;
import com.ittraining.main.models.Domaine;
import com.ittraining.main.models.Employe;
import com.ittraining.main.models.Formateur;
import com.ittraining.main.models.Formation;
import com.ittraining.main.models.Prerequis;
import com.ittraining.main.models.Role;
import com.ittraining.main.models.Session;
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


		Client c1 = new Client("Taylor", "John", "john", "john@mail.com", null);
		Client c2 = new Client("Monceau", "Rose", "rose", "rose@mail.com", null);
		Client c3 = new Client("Bean", "Tony", "tony", "tony@mail.com", null);
		Client c4 = new Client("Natoni", "Maya", "maya", "maya@mail.com", null);
		Client c5 = new Client("Gronchon", "Richard", "richard", "richard@mail.com", null);
		Client c6 = new Client("Bellami", "Louise", "louise", "louise@mail.com", null);
		clientRepository.save(c1);
		clientRepository.save(c2);
		clientRepository.save(c3);
		clientRepository.save(c4);
		clientRepository.save(c5);
		clientRepository.save(c6);
		
		List<Client> clientsSession1 = new ArrayList<>();
		clientsSession1.add(c1);
		clientsSession1.add(c2);
		List<Client> clientsSession2 = new ArrayList<>();
		clientsSession2.add(c3);
		clientsSession2.add(c5);
		List<Client> clientsSession3 = new ArrayList<>();
		clientsSession3.add(c2);
		clientsSession3.add(c4);
		clientsSession3.add(c6);
		
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
		
		Employe e1 = new Employe("Hamida", "Aicha", "aicha", "hamida.aicha@it-training.com", null, null);
		Employe e2 = new Employe("Di Lorenzo", "Lucas", "lucas", "dilorenzo.lucas@it-training.com", null, null);
		Employe e3 = new Employe("Heuillet", "Cecile", "cecile", "heuillet.cecile@it-training.com", null, null);
		employeRepository.save(e1);
		employeRepository.save(e2);
		employeRepository.save(e3);
		
		Role r1 = new Role("Admin", null);
		roleRepository.save(r1);
		Role r2 = new Role("Employe", null);
		roleRepository.save(r2);
		
		List<Role> roles1 = new ArrayList<>();
		roles1.add(r1);
		roles1.add(r2);
		
		List<Role> roles2 = new ArrayList<>();
		roles2.add(r1);
		
		e1.setRoles(roles1);
		e2.setRoles(roles2);
		e3.setRoles(roles2);
		employeRepository.save(e1);
		employeRepository.save(e2);
		employeRepository.save(e3);
		
		Formateur fo1 = new Formateur("Gregoire", "Bruno", "bruno", "gregoire.bruno@it-training.com", null);
		Formateur fo2 = new Formateur("Lieutaud", "Caroline", "caroline", "lieutaud.caroline@it-training.com", null);
		Formateur fo3 = new Formateur("Matui", "Damien", "damien", "matui.damien@it-training.com", null);
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
				e1, "Développeur Java JEE", 98);
		formationRepository.save(f1);
		Formation f2 = new Formation(d1, t2, 8860.00, null, null, "Disposer des connaissances et compétences nécessaires pour identifier et collecter des données et s'assurer de leur qualité et de leur alignement sur les besoins et usages métiers de l'entreprise.",
				"Les entreprises collectent aujourd'hui de tels volumes d'informations que leur exploitation avec des méthodes traditionnelles est devenue impossible. Pourtant, ces informations sont des mines d'or ! Mais encore faut-il savoir les traiter, les analyser et en tirer la substantifique moelle. C'est précisément la mission qui incombe au Data Scientist qui en imaginant de nouveaux modèles et en utilisant de nouveaux outils va donner du sens aux données et en extraire de la valeur pour aider l'entreprise à prendre des décisions. A la fois spécialiste des données, des chiffres, des statistiques, des outils informatiques et grand connaisseur du secteur pour lequel il analyse des données, le Data Scientist est aussi un créatif qui doit savoir utiliser les outils de restitution de données pour restituer de façon claire et convaincante le résultat de ses analyses.",
				"Objectif : Disposer des connaissances et compétences nécessaires pour identifier et collecter des données et s'assurer de leur qualité et de leur alignement sur les besoins et usages métiers de l'entreprise. Les nouvelles frontières du Big Data (introduction) : immersion, l'approche des 4 Vs, cas d'usages du Big Data, technologies, architecture, master-less vs master-slaves, stockage, Machine Learning, Data Scientist et Big Data, compétences, la vision du Gartner, valeur ajoutée du Big Data. La collecte des données : typologie des sources, les données non structurées, typologie 3V des sources, les données ouvertes (Open Data), nouveau paradigme de l'ETL à l'ELT, le concept du Data Lake, les API de réseaux sociaux. Le calcul massivement parallèle : genèse et étapes clés, Hadoop, HDFS, MapReduce, Apache PIG et Apache HIVE, comparatif des 3 approches, limitations de MapReduce, moteur d'exécution Apache TEZ, la rupture Apache SPARK, Hive in Memory (LLAP), Big Deep Learning. Les nouvelles formes de stockage : enjeux, le 'théorème' CAP, nouveaux standards : ACID => BASE, panorama des bases de données NoSQL, bases de données Clé-Valeur, bases de données Document, bases de données colonnes, bases de données Graphes. Le Big Data Analytics (fondamentaux) : analyse de cas concrets, que peuvent apprendre les machines ? , les différentes expériences (E), l'apprentissage, choisir un algorithme d'apprentissage machine, anatomie d'un modèle d'apprentissage automatique, les librairies de machine learning standards et Deep Learning, les plates-formes de Data Science. Le Big Data Analytics (écosystème SPARK) : les différents modes de travail, les 3 systèmes de gestion de cluster, modes d'écriture des commandes Spark, machine learning avec Spark , travail sur les variables prédictives, la classification et la régression. Traitement en flux du Big Data (​streaming​ ) : architectures types de traitement de Streams Big Data, Apache NIFI, Apache KAFKA, articulation NIFI et KAFKA, Apache STORM, articulation KAFKA et STORM, comparatif STORM/SPARK. Déploiement d'un projet Big Data : Cloud Computing , 5 caractéristiques essentielles, 3 modèles de services, modes (SaaS , PaaS, IaaS), Cloud Privé virtuel (VPC), focus AWS, GCP et Azure. Hadoop écosystème et distributions : écosystème, fonctions coeurs, HDFS, Map Reduce, infrastructure YARN, distributions Hadoop, focus Cloudera, Focus Hortonworks. Architecture de traitement Big Data : traitement de données par lots, traitement de données en flux, modèles d'architecture de traitement de données Big Data, l'heure du choix. La gouvernance des données Big Data : outils de gouvernance Big Data, les 3 piliers, le management de la qualité des données, le management des métadonnées Big Data, management de la sécurité, de la conformité et la confidentialité.",
				e2, "Data Scientist", 126);
		formationRepository.save(f2);
		Formation f3 = new Formation(d1, t2, 11320.00, null, null, "Découvrir les techniques de base du hacking et comprendre comment les mécanismes et outils de sécurité peuvent constituer un premier rempart.",
				"Il ne se passe pas une semaine sans que les médias n'évoquent des actes de piratage touchant de grandes entreprises, des acteurs de la nouvelle économie ou ... des états. Vol d'informations stratégiques, de fichiers clients, détournements de fonds bancaires, neutralisation de serveurs web... Et bien sûr, il est facile de comprendre qu'au-delà du préjudice financier, il y a toujours un important préjudice d'image. Il n'est donc pas surprenant que de nombreuses entreprises cherchent à se prémunir de ce type de risques. Pour autant, elles peinent souvent à trouver les profils capables de sécuriser efficacement leur SI et de mettre en échec les tentatives d'intrusion des (hackers). A l'issue de ce cursus de 23 jours, les participants disposeront précisément des connaissances et compétences nécessaires à l'atteinte de ces objectifs.",
				"Objectif : découvrir les techniques de base du hacking et comprendre comment les mécanismes et outils de sécurité peuvent constituer un premier rempart. Les fondamentaux de la sécurité des réseaux : prise d'informations à distance sur des réseaux d'entreprise et des systèmes distants, consultation d'informations publiques, localisation un système cible, énumération des services actifs. Les attaques à distance : intrusion à distance des postes clients par exploitation des vulnérabilités sur les services distants, et prise de contrôle des postes utilisateurs par troyen, authentification par brute force, recherche et exploitation de vulnérabilités sur un système cible, prise de contrôle à distance. Les attaques systèmes : outrepasser l'authentification et/ou surveiller l'utilisateur suite à une intrusion, attaque du Bios, cracking de mot de passe et espionnage du système. Sécuriser le système : les outils de base permettant d'assurer le minimum de sécurité à un S.I., la cryptographie, le chiffrement des données, la détection d'activité anormale, le rôle de la base de registre, le firewalling, l'anonymat.",
				e3, "Expert en cybersécurité", 161);
		formationRepository.save(f3);
		Formation f4 = new Formation(d1, t1, 6970.00, null, null, "Acquérir la connaissance des commandes fondamentales des systèmes d'exploitation Linux et développer un premier niveau d'autonomie en vue de la prise en main d'un système.",
				"Il ne se passe pas une semaine sans que les médias n'évoquent des actes de piratage touchant de grandes entreprises, des acteurs de la nouvelle économie ou ... des états. Vol d'informations stratégiques, de fichiers clients, détournements de fonds bancaires, neutralisation de serveurs web... Et bien sûr, il est facile de comprendre qu'au-delà du préjudice financier, il y a toujours un important préjudice d'image. Il n'est donc pas surprenant que de nombreuses entreprises cherchent à se prémunir de ce type de risques. Pour autant, elles peinent souvent à trouver les profils capables de sécuriser efficacement leur SI et de mettre en échec les tentatives d'intrusion des (hackers). A l'issue de ce cursus de 23 jours, les participants disposeront précisément des connaissances et compétences nécessaires à l'atteinte de ces objectifs.",
				"Objectif : acquérir la connaissance des commandes fondamentales des systèmes d'exploitation Linux et développer un premier niveau d'autonomie en vue de la prise en main d'un système. Introduction. Une session : démarrage, commandes et documentation. Les fichiers et les répertoires : arborescence, chemins, commandes de gestion de fichiers et de répertoires. Le Shell : présentation, réalisation d'un script élémentaire. Les droits : gestion des droits et des groupes. L'impression : principes et commandes. Les filtres : présentation, commandes grep, cut, sed, sort, more et pg. La sauvegarde : commandes tar et cpio. Les outils de communication : commandes write, talk et mail. Les liens : commandes, liens symboliques. La gestion des processus : commandes kill, ps, gestion des travaux. L'éditeur vi : commandes, modes et paramétrage de vi. Unix et les réseaux : comprendre TCP/IP, connexion à distance, transfert de fichiers.",
				e1, "Administrateur Linux", 119);
		formationRepository.save(f4);
		Formation f5 = new Formation(d2, t3, 1650.00, null, null, "La formation Management et gestion de projets opérationnels vous permettra d'acquérir les compétences pour piloter les projets, manager les équipes, tenir les délais et budgets.",
				"Objectifs pédagogiques / Compétences visées : Conduire une réunion de conception de projet. Concevoir un projet à mettre en oeuvre dans votre entreprise. Conduire une équipe projets de manière assertive, pour contribuer ensemble à la mise en place du projet. Conduire les réunions projets. Etablir un plan d'action (organigramme des tâches, ressources...). Conduire les projets. Composer et conduire vos équipes. Préparer et partager l'avancement du projet. Etablir les budgets. Anticiper et analyser les risques. Etablir une culture d'entreprise. Créer une base de données multi-projets.",
				"Introduction. Présentation de chacun. Attentes et objectifs visés de chaque participant. Présentation de la formation. Suis-je crédible ? Vendre sa solution. Le management transverse. La communication avec les équipes. Les 25 erreurs à éviter. Les motivations d'adhésion au projet. La résistance aux changements. Les leviers d'influence. Comment fédérer mon équipe projets ? Les différences culturelles. L'éloignement géographique. Les hiérarchies différentes. Les différences comportementales. Les règles d'un projet. Les conflits et arbitrages. La charte projets. Les luttes de pouvoir internes au projet. Les enjeux politiques. Communiquer sur le projet. Importance de la communication. Par où commencer ? Management des projets. Définition du projet. Management, gestion et direction du projet. Les facteurs de succès des projets. La gestion du risque. La note de lancement du projet. Importance d'une bonne préparation. La note de lancement du projet. La réunion de lancement. Les différents types d'organisation. Constituer son équipe projet. Les différents acteurs. Composition de l'équipe. Conduire les réunions de projets. La conduite de réunion. Les réunions de projets. Les revues de projets. Les comités de pilotage. Quelle organisation pour mon projet ? La structuration du projet. L'organigramme des tâches. L'organigramme des ressources. L'organigramme des coûts. Le calendrier des objectifs. Les différentes phases d'un projet. La mise en place des jalons. La planification de projets. Les plannings (GANTT et PERT). Le chemin critique. L'avancement des travaux. Coordination et suivi. Importance de la coordination. Les outils de suivi. Les comptes-rendus. Le tableau de bord. La gestion multi-projets. Identification et positionnement des risques du projet. Identification des risques. Typologie des risques. Spécificité des risques. Méthodes d'identification. Configuration. Facteurs de risque. Culture projet dans l'entreprise. Kit de procédures. Base de données multi-projets. Révision des points abordés dans le programme. Synthèse de la session. Réflexion sur les applications concrètes que chacun peut mettre en oeuvre dans son environnement. Conseils personnalisés donnés par l'animateur à chaque participant. Bilan oral et évaluation à chaud.",
				e3, "Management et gestion de projets opérationnels", 24);
		formationRepository.save(f5);
		Formation f6 = new Formation(d2, t4, 2860.00, null, null, "Développer vos compétences en communication interpersonnelle et en option préparer la certification en communication interpersonnelle.",
				"Objectifs pédagogiques / Compétences visées : Conduire une réunion de conception de projet. Concevoir un projet à mettre en oeuvre dans votre entreprise. Conduire une équipe projets de manière assertive, pour contribuer ensemble à la mise en place du projet. Conduire les réunions projets. Etablir un plan d'action (organigramme des tâches, ressources...). Conduire les projets. Composer et conduire vos équipes. Préparer et partager l'avancement du projet. Etablir les budgets. Anticiper et analyser les risques. Etablir une culture d'entreprise. Créer une base de données multi-projets.",
				"Cette formation est animée par un intervenant certifié auprès de KCF (Kahler Communication France). A l'issue de la formation, passage de la certification :  Examen en ligne avec le simulateur. Le candidat devra avoir obtenu un score de 80% minimum. La réussite de l'examen en ligne est un prérequis pour passer l'examen oral. Examen oral par Skype avec un certificateur agréé. Le certificateur propose au candidat 3x3 interactions par type de personnalité avec une exigence de 2 interventions sur 3 réussies. En cas d'échec, le candidat peut repasser 2 fois l'examen écrit et oral sans surcoût, uniquement sur les épreuves sur lesquelles il a échoué. Pour plus d'informations concernant les tarifs INTRA, contactez votre conseiller formation.",
				e2, "Individualisez votre communication", 40);
		formationRepository.save(f6);
		
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
