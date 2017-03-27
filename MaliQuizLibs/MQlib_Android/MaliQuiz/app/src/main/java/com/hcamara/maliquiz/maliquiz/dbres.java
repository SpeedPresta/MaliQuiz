package com.hcamara.maliquiz.maliquiz;

/**
 * Created by hcamara on 23/03/2017.
 */

public class dbres {

    static String quiz = "La lutte du 26 mars 1991 fut menée par ...;Etudiants,,Elèves,,Syndicats,,Les trois;Les trois;Si j'ai bonne mémoire c'est les 3#" +
                         "La lutte du 26 mars eut lieu en ...;1990,,1989,,1991,,1992;1991;Si j'ai bonne mémoire c'était juste après 1990#" +
                         "Sous quel régime s'est déroule la lutte du 26 mars ?;Moussa Traoré,,Modibo Keita,,ATT,,Alpha Oumar;Moussa Traoré;Si j'ai bonne mémoire c'etait après le coup d'état de Modibo Keita #" +
                         "Sur quel pont les militaires tiraient à balles réelles sur les manifestants ? ;Des tirs,,Martyres,,La rébellion,,L'honneur;Martyres;Si j'ai bonne mémoire c'était lié au mot Martyrs#" +
                         "Comment fût nommer le jour de la manifestation?;Martyrs,,26 mars,, Lutte Day,, Mars 1991;26 mars;si j'ai bonne mémoire c'était le 26 mars ou pas!#" +
                         "Que fut les commandos du vendredi noir aux manifestants ?;Brulé vif,,Rien,,Tirs,,Chassés;Brulé vif;Si j'ai bonne mémoire ça avait un lien avec le feu#" +
                         "Par qui fut mené le renversement du  régime de Moussa Traoré à l’anniversaire du 26 Mars 91 ?;Alpha Oumar,,Modibo Keita,,ATT,,IBK;ATT;Si j'ai bonne mémoire il faisait parti de l'armée#" +
                         "Quel était le but de cette révolution vis-à-vis du chef de l'état ?;Les élections,,Une loi,,Emplois,,Son départ;Son départ;Si j'ai bonne mémoire le peuple ne voulais plus de son chef d'état à l'époque#" +
                         "Le chef des manifestants Étudiants se faisait appeler...;Cabral,,Nostra,,Rasbath,,Liberté;Cabral;Si j'ai bonne mémoire son nom commençait par un 'C'#" +
                         "Quelles furent les causes de la révolution du 26 mars 1991 ?;Famine,,Corruption,,Arrêt écoles,,Les trois;Les trois;Si j'ai bonne mémoire il y'avait plusieurs causes#" +
                         "Avant le coup d’Etat de 1991 combien de partis politiques le Mali comptait ils ?;2,,5,,1,,3;1;Si j'ai bonne mémoire il y'avait que celui de Moussa Traoré #" +
                         "A quel corps de l’armée appartenait les militaires qui renversèrent Moussa Traoré ?;Terre,,L'air,,Parachutistes,,Commandos;Parachutistes;Si j'ai bonne mémoire c'était un parachutiste#" +
                         "Quel était le grade de l'auteur du coup d'Etat Amadou Toumani Touré?;Capitaine,,Général,,Lieutenant-Colonel,,Colonel;Lieutenant-Colonel;si j'ai bonne mémoire c'était Lieutenant-Colonel mais je suis pas sûr#" +
                         "Sur quoi, sur quel régime politique à aboutit la fin du règne de Moussa Traoré?;Dictature,,Démocratie,,L'Anarchie,,Socialiste;Démocratie;Si j'ai bonne mémoire la lutte de 91 à abouti à la démocratie#" +
                         "Par quel procéder Moussa Traoré est il arriver au pouvoir ?;Coup d'état,,Election,,Interim,,Loi;Coup d'état;Si j'ai bonne mémoire c'etait par la force#" +
                         "Combien de temps Moussa Traoré a t'il régner ?;5ans,,13ans,,23ans,,30;23ans;Si j'ai bonne mémoire c'est plus de 20ans et moins de 30ans#" +
                          "Quel a été l'action des femmes pour soutenir leurs enfants ?;Manifestations,,Reunions,,Coup d'état,,Rien;Manifestations;Si j'ai bonne mémoire c'était des manifestations#" +
                           "En signe de représailles contre les manifestants le président Moussa Traoré leur a promis l'enfer sur ...;Terre,,Leur tête,,bain de sang,,Le pont;Leur tête;Si j'ai bonne mémoire c'était pas l'enfer sur terre#" +
                           "Les commandos venus à la rencontre des manifestants été équipée de ?;Lance pierre,,Jet d'eau,,Lance flamme,,Ak47;Lance flamme;Si j'ai bonne mémoire c'était des flammes#" +
                           "Moussa traoré a régné de ...;1965 - 1990,,1989 - 1992,,1967 - 1991,,1968 - 1991;1968 - 1991;Si j'ai bonne mémoire il a fait environ 23 ans au pouvoir#";



    static String[] getQuiz(){
        return (quiz.split("#"));
    }

}
