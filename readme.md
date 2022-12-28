Java Server Pages (JSP) est un cadre de programmation côté serveur qui permet aux développeurs de créer des applications Web dynamiques et indépendantes de la plate-forme. Les JSP ont accès à toute la famille des API Java , y compris l'API JDBC (Application Programming Interface), qui leur permet de se connecter aux bases de données métiers.

Ici, j'ai developpé une application Web Java de base qui gère les Étudiants d'une établissement scolaire et inclut les fonctionnalités suivantes : liste, insertion, mise à jour et suppression (ou opérations CRUD - Créer, Mettre à jour, Lire et Effacer)

C'est une simple application Web basée sur l'API Servlet de Java comportant les opérations de base (CRUD) configurée avec apache-tomcat-10 ...

Configuration de la base de donnée : après avoir clonner et télecharger les dependances nécessaires au bon fonctionnement du projet..Veuillez fournir à Hibernate la configuration de votre base de donnée en modifiant les informations suivantes, dans le fichier "HibernateConfig.java" qui se trouve dans le package "config" : 
	
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/crud_jsp?createDatabaseIfNotExist=true&useSSL=false") : changer "crud_jsp" par le nom de votre base de donnée
        settings.put(Environment.USER, "username") : changer "username" par le nom de l'utilisateur pour se connecter à MySQL
        settings.put(Environment.PASS, "password") : changer "password" par le mot de passe de l'utilisateur pour se connecter à MySQL
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect") : changer la version du dialect MySQL utilisé pour qu'elle correspond à celle qui est installée dans votre système

Les routes disponibles sur l'application : 
	/list : lister tous les ressources 
	/new : créer un ressources
	/update : mettre à jour un ressource
	/delete : supprimer un ressource
 
N.B : Cette application est developpée avec Java 11 
Made By Solo Soaniaina 2022 ...
