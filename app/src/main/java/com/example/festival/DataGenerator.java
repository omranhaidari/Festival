package com.example.festival;

import com.example.festival.database.Groupe;

public class DataGenerator {

    // Cette fonction permet de remplir la base de données SQLite
    public static void fillDatabase(){
        // VENDREDI - SALLE AMPLIFIEE //
        Groupe coldplay = new Groupe("Coldplay",
                "coldplay",
                "Vendredi",
                "Amplifiée",
                "19h15",
                "   Coldplay est un groupe britannique créé en 1996. " +
                        "Il est formé par l'auteur-compositeur-interprète Chris Martin et le " +
                        "guitariste Jon Buckland. Le bassiste Guy Berryman rejoint ensuite le groupe, " +
                        "avant que le batteur Will Champion ne vienne compléter le quatuor. " +
                        "Avec huit albums studio, Coldplay est l'un des plus grands groupes à " +
                        "succès du nouveau millénaire, avec plus de 90 millions de disques vendus à " +
                        "travers le monde."
                ,"www.coldplay.com",
                false);
        coldplay.save();

        Groupe u2 = new Groupe("U2",
                "u2",
                "Vendredi",
                "Amplifiée",
                "21h",
                "   U2 est un groupe rock irlandais originaire de Dublin, formé en 1976. " +
                        "Il est composé de Bono au chant et occasionnellement à la guitare ; The Edge" +
                        " à la guitare, au piano et au chant ; Adam Clayton à la basse ; et Larry Mullen Jr. " +
                        "à la batterie. Depuis les années 1980, U2 s'impose comme un groupe majeur sur la scène mondiale.",
                "www.u2.com",
                false);
        u2.save();

        Groupe rammstein = new Groupe("Rammstein",
                "rammstein",
                "Vendredi",
                "Amplifiée",
                "22h45",
                "   Rammstein est un groupe de metal industriel allemand, originaire de Berlin. " +
                        "Formé en 1994, il se compose depuis le début de six membres originaires d'Allemagne " +
                        "de l'Est. Les paroles du groupe sont la plupart du temps en allemand, c'est " +
                        "d'ailleurs le groupe germanophone le plus vendu dans le monde avec près de " +
                        "20 millions d'albums vendus, mais il intègre parfois aussi des paroles en " +
                        "anglais, en français, en espagnol, ou encore en russe.",
                "www.rammstein.com",
                false);
        rammstein.save();

        // VENDREDI - SALLE ACOUSTIQUE //
        Groupe indochine = new Groupe("Indochine",
                "indochine",
                "Vendredi",
                "Acoustique",
                "18h45",
                "   Indochine est un groupe de pop rock français. Formé en 1981, le groupe est" +
                        " issu du courant new wave. Indochine est le premier groupe de rock français à" +
                        " remplir le Palais Omnisports de Paris-Bercy (en 2003) et le Stade de France (en 2010)." +
                        " De plus, Indochine est l'un des rares groupes français à s'exporter dans d'autres pays. " +
                        "Avec plus de 13 millions de disques vendus, c'est le groupe français ayant vendu le plus de disques.",
                "www.indo.fr",
                false);
        indochine.save();

        Groupe beatles = new Groupe("The Beatles",
                "beatles",
                "Vendredi",
                "Acoustique",
                "22h",
                "   The Beatles est un groupe de pop et de rock'n'roll, originaire de Liverpool, en Angleterre. " +
                        "Le noyau du groupe se forme avec les Quarrymen fondés par John Lennon en 1957, " +
                        "il adopte son nouveau nom en 1960 et, à partir de 1962, prend sa configuration " +
                        "définitive, composé de John Lennon, Paul McCartney, George Harrison et, le " +
                        "dernier à se joindre, Ringo Starr. Il est considéré comme le groupe le plus " +
                        "populaire et influent de l’histoire du rock.",
                "www.thebeatles.com",
                false);
        beatles.save();

        // SAMEDI - SALLE AMPLIFIEE //
        Groupe acdc = new Groupe("AC/DC",
                "acdc",
                "Samedi",
                "Amplifiée",
                "20h",
                "   AC/DC est un groupe de hard rock britannico-australien, originaire de Sydney. " +
                        "Il est formé en 1973 par les frères écossais Angus et Malcolm Young. Bien " +
                        "que classé dans le hard rock et considéré comme un pionnier de ce genre " +
                        "musical ainsi que parfois du heavy metal, les membres du groupe ont " +
                        "toujours qualifié leur musique de « rock 'n' roll ». Elle pourrait aussi" +
                        " être catégorisée comme hard blues.",
                "www.acdc.com",
                false);
        acdc.save();

        Groupe daftPunk = new Groupe("Daft Punk",
                "daft_punk",
                "Samedi",
                "Amplifiée",
                "22h15",
                "   Daft Punk est un groupe de musique électronique français, originaire de Paris. " +
                        "Composé de Thomas Bangalter et Guy-Manuel de Homem-Christo, le groupe est " +
                        "actif depuis 1993, et participe à la création et à la démocratisation du " +
                        "mouvement de musique électronique baptisé french touch. Ils font partie des" +
                        " artistes français s'exportant le mieux à l'étranger. Une des originalités de" +
                        " Daft Punk est la culture de leur notoriété d'artistes indépendants et sans" +
                        " visage, portant toujours en public des casques et des costumes.",
                "www.daftpunk.com",
                false);
        daftPunk.save();

        // SAMEDI - SALLE ACOUSTIQUE //
        Groupe nirvana = new Groupe("Nirvana",
                "nirvana",
                "Samedi",
                "Acoustique",
                "19h",
                "   Nirvana est un groupe de grunge américain, originaire d'Aberdeen, dans " +
                        "l'État de Washington, aux Etats-Unis. formé en 1987 par le chanteur-guitariste" +
                        " Kurt Cobain et le bassiste Krist Novoselic. Après Bleach en 1989, son premier" +
                        " album studio produit par le label indépendant Sub Pop et une succession de" +
                        " batteurs, la formation se stabilise avec l'arrivée de Dave Grohl en octobre" +
                        " 1990.",
                "www.nirvana.com",
                false);
        nirvana.save();

        Groupe muse = new Groupe("Muse",
                "muse",
                "Samedi",
                "Acoustique",
                "20h45",
                "   Muse est un groupe de rock britannique, originaire de Teignmouth, dans " +
                        "le Devon, en Angleterre. Apparu sur la scène musicale en 1994, le trio est " +
                        "composé de Matthew Bellamy (chant, guitare, piano), Christopher Wolstenholme" +
                        " (basse, harmonica, chant, chœurs) et Dominic Howard (batterie, percussions).",
                "www.muse.mu",
                false);
        muse.save();

        Groupe justice = new Groupe("Justice",
                "justice",
                "Samedi",
                "Acoustique",
                "22h30",
                "   Justice est un groupe de musique électronique français, originaire de Paris." +
                        " Formé en 2003, le groupe est composé de Gaspard Augé et de Xavier de Rosnay1." +
                        " Le duo est considéré comme appartenant à « la deuxième génération de la French touch »",
                "www.justice.church",
                false);
        justice.save();
    }

    // Cette fonction permet de vider la base de données SQLite
    public static void cleanDatabase(){
        Groupe.deleteAll(Groupe.class);
    }
}