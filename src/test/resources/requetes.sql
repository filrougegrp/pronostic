--init requetes


-- MAROUANE 

 /*Selectionner les pays avec ses poules*/
SELECT pa.NOM,po.NOM from PAYS pa 
	INNER JOIN POULE_PAYS pp on pp.ID_PAYS = pa.ID_PAYS 
    INNER JOIN POULE po on po.ID_POULE = pp.ID_POULE;
    
/*Selectionner les pays d'un poule donner*/
SELECT pa.NOM,po.NOM from PAYS pa 
	INNER JOIN POULE_PAYS pp on pp.ID_PAYS = pa.ID_PAYS 
	INNER JOIN POULE po on po.ID_POULE = pp.ID_POULE 
	where po.NOM = 'A' 
	
/*lister les equipes d'une tournoi*/
SELECT pa.NOM FROM PAYS pa
	INNER JOIN POULE_PAYS pp on pp.ID_PAYS = pa.ID_PAYS 
    INNER JOIN POULE po on po.ID_POULE = pp.ID_POULE AND po.GROUPE = 1
	INNER JOIN COMPETITION co on co.ID_COMPETITION = po.ID_COMPETITION
    where po.GROUPE = 1;
    
/*nbr des equipes d'un tournoi*/
SELECT count(1) FROM PAYS pa
	INNER JOIN POULE_PAYS pp on pp.ID_PAYS = pa.ID_PAYS 
    INNER JOIN POULE po on po.ID_POULE = pp.ID_POULE AND po.GROUPE = 1
	INNER JOIN COMPETITION co on co.ID_COMPETITION = po.ID_COMPETITION
    where po.GROUPE = 1;
    
/*affiher la list des salariers dont la diff des buts des pronostic egaule la diff des buts réel*/
 select s.NOM , s.PRENOM ,p1.NOM, p.BUT_1, p.BUT_2, p2.NOM ,r.BUT_1,r.BUT_2 from SALARIE s 
 	inner join PRONOSTIC p on s.ID_SALARIE = p.ID_SALARIE 
 	inner join RENCONTRE r on r.ID_RENCONTRE = p.ID_RENCONTRE 
 	inner join PAYS p1 on p1.ID_PAYS = r.ID_PAYS_1 
 	inner join PAYS p2 on p2.ID_PAYS = r.ID_PAYS_2 
 	where (p.BUT_1 - p.BUT_2) = (r.BUT_1-r.BUT_2)
 
 	/*afficher la list des salaries dont les pronostic est correcte*/
 select s.NOM , s.PRENOM ,p1.NOM, p.BUT_1, p.BUT_2, p2.NOM ,r.BUT_1,r.BUT_2 from SALARIE s 
 	inner join PRONOSTIC p on s.ID_SALARIE = p.ID_SALARIE 
 	inner join RENCONTRE r on r.ID_RENCONTRE = p.ID_RENCONTRE 
 	inner join PAYS p1 on p1.ID_PAYS = r.ID_PAYS_1 
 	inner join PAYS p2 on p2.ID_PAYS = r.ID_PAYS_2 
 	where p.BUT_1 = r.BUT_1 and p.BUT_2 = r.BUT_2

-- AMINE

    -- select les pays de tous les poules
select po.NOM, pa.NOM from POULE po 
	inner join POULE_PAYS pp on po.ID_POULE = pp.ID_POULE 
	inner join PAYS pa on pa.ID_PAYS = pp.ID_PAYS;
    
	-- select les pronostic d'un salarie
select s.NOM , s.PRENOM ,p1.NOM,p2.NOM, p.BUT_1, p.BUT_2, r.ID_RENCONTRE from SALARIE s
	inner join PRONOSTIC p on s.ID_SALARIE = p.ID_SALARIE 
	inner join RENCONTRE r on r.ID_RENCONTRE = p.ID_RENCONTRE 
	inner join PAYS p1 on p1.ID_PAYS = r.ID_PAYS_1
	inner join PAYS p2 on p2.ID_PAYS = r.ID_PAYS_2 
	where s.ID_SALARIE = 3;
	
--MOHAMED


-- http://www.marcphilipp.de/blog/2012/03/19/using-dbunit-without-xml/
-- http://dbunit.sourceforge.net/howto.html
-- http://dbsetup.ninja-squad.com/user-guide.html










