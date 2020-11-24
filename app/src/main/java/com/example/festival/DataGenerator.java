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
                "Rammstein est un groupe de metal industriel allemand, originaire de Berlin.",
                "www.rammstein.com",
                false);
        rammstein.save();

        // VENDREDI - SALLE ACOUSTIQUE //
        Groupe indochine = new Groupe("Indochine",
                "indochine",
                "Vendredi",
                "Acoustique",
                "18h45",
                "Indochine est un groupe de pop rock français. Formé en 1981, le groupe est issu du courant new wave.",
                "www.indo.fr",
                false);
        indochine.save();

        Groupe pinkFloyd = new Groupe("Pink Floyd",
                "pink_floyd",
                "Vendredi",
                "Acoustique",
                "20h30",
                "Pink Floyd est un groupe rock britannique originaire de Londres en Angleterre.",
                "www.pinkfloyd.com",
                false);
        pinkFloyd.save();

        Groupe beatles = new Groupe("The Beatles",
                "beatles",
                "Vendredi",
                "Acoustique",
                "22h",
                "The Beatles est un groupe de pop et de rock'n'roll, originaire de Liverpool, en Angleterre.",
                "www.thebeatles.com",
                false);
        beatles.save();

        // SAMEDI - SALLE AMPLIFIEE //
        Groupe linkinPark = new Groupe("Linkin Park",
                "linkin_park",
                "Samedi",
                "Amplifiée",
                "18h30",
                "Linkin Park est un groupe de rock/metal américain, originaire d'Agoura Hills, en Californie.",
                "www.linkinpark.com",
                false);
        linkinPark.save();

        Groupe acdc = new Groupe("AC/DC",
                "acdc",
                "Samedi",
                "Amplifiée",
                "20h",
                "AC/DC est un groupe de hard rock britannico-australien, originaire de Sydney.",
                "www.acdc.com",
                false);
        acdc.save();

        Groupe daftPunk = new Groupe("Daft Punk",
                "daft_punk",
                "Samedi",
                "Amplifiée",
                "22h15",
                "Daft Punk est un groupe de musique électronique français, originaire de Paris.",
                "www.daftpunk.com",
                false);
        daftPunk.save();

        // SAMEDI - SALLE ACOUSTIQUE //
        Groupe nirvana = new Groupe("Nirvana",
                "nirvana",
                "Samedi",
                "Acoustique",
                "19h",
                "Nirvana est un groupe de grunge américain, originaire d'Aberdeen, dans l'État de Washington.",
                "www.nirvana.com",
                false);
        nirvana.save();

        Groupe muse = new Groupe("Muse",
                "muse",
                "Samedi",
                "Acoustique",
                "20h45",
                "Muse est un groupe de rock britannique, originaire de Teignmouth, dans le Devon, en Angleterre.",
                "www.muse.mu",
                false);
        muse.save();

        Groupe justice = new Groupe("Justice",
                "justice",
                "Samedi",
                "Acoustique",
                "22h30",
                "Justice est un groupe de musique électronique français, originaire de Paris.",
                "www.justice.church",
                false);
        justice.save();
    }

    // Cette fonction permet de vider la base de données SQLite
    public static void cleanDatabase(){
        Groupe.deleteAll(Groupe.class);
    }
}