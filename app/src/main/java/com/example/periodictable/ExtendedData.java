package com.example.periodictable;

public class ExtendedData {
    public String bp, mp, uses, funFact, discoverer, year, origin;

    public ExtendedData(String bp, String mp, String uses, String funFact, String discoverer, String year, String origin) {
        this.bp = bp;
        this.mp = mp;
        this.uses = uses;
        this.funFact = funFact;
        this.discoverer = discoverer;
        this.year = year;
        this.origin = origin;
    }

    public static String getMp(int num) {
        if (num < 1 || num > 118) return "Unknown";
        String[] mps = {
            "-259.1", "-272.2", "180.5", "1287", "2076", "3550", "-210.0", "-218.8", "-219.6", "-248.6",
            "97.8", "650", "660.3", "1414", "44.1", "115.2", "-101.5", "-189.4", "63.5", "842",
            "1541", "1668", "1910", "1907", "1246", "1538", "1495", "1455", "1084.6", "419.5",
            "29.7", "938.3", "817", "221", "-7.2", "-157.4", "39.3", "777", "1522", "1855",
            "2477", "2623", "2157", "2334", "1964", "1555", "961.8", "321", "156.6", "231.9",
            "630.6", "449.5", "113.7", "-111.8", "28.5", "727", "920", "795", "931", "1024",
            "1042", "1072", "822", "1312", "1356", "1412", "1474", "1529", "1545", "824",
            "1652", "2233", "3017", "3422", "3186", "3033", "2446", "1768", "1064", "-38.8",
            "304", "327.5", "271.4", "254", "302", "-71", "27", "700", "1050", "1750",
            "1568", "1132", "644", "640", "1176", "1340", "986", "900", "860", "1527",
            "827", "827", "1627", "2100", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown",
            "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown"
        };
        String val = mps[num - 1];
        return "Unknown".equals(val) ? val : val + "°C";
    }

    public static String getBp(int num) {
        if (num < 1 || num > 118) return "Unknown";
        String[] bps = {
            "-252.9", "-268.9", "1342", "2469", "3927", "4827", "-195.8", "-183.0", "-188.1", "-246.1",
            "883", "1090", "2470", "3265", "280.5", "444.6", "-34.0", "-185.8", "759", "1484",
            "2836", "3287", "3407", "2671", "2061", "2862", "2927", "2730", "2562", "907",
            "2204", "2833", "614", "685", "58.8", "-153.2", "688", "1382", "3338", "4409",
            "4744", "4639", "4265", "4150", "3695", "2963", "2162", "767", "2072", "2602",
            "1587", "988", "184.3", "-108.1", "671", "1897", "3464", "3443", "3520", "3074",
            "3000", "1794", "1527", "3250", "3230", "2567", "2700", "2868", "1950", "1196",
            "3402", "4603", "5458", "5555", "5596", "5012", "4130", "3825", "2856", "356.7",
            "1473", "1749", "1564", "962", "337", "-61.7", "677", "1737", "3198", "4788",
            "4027", "4131", "3902", "3228", "2607", "3110", "2627", "1470", "996", "Unknown",
            "Unknown", "Unknown", "Unknown", "5500", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown",
            "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown"
        };
        String val = bps[num - 1];
        return "Unknown".equals(val) ? val : val + "°C";
    }

    public static ExtendedData get(int num, String name) {
        switch(num) {
            case 1: return new ExtendedData(getBp(num), getMp(num), "Rocket fuel, petroleum refining, fertilizer production.", "Hydrogen is the most abundant element in the universe.", "Henry Cavendish", "1766", "UK");
            case 2: return new ExtendedData(getBp(num), getMp(num), "Balloons, deep-sea diving, cooling superconducting magnets.", "Helium is the only element that cannot be solidified by sufficient cooling at normal atmospheric pressure.", "Pierre Janssen & Norman Lockyer", "1868", "France/UK");
            case 3: return new ExtendedData(getBp(num), getMp(num), "Rechargeable batteries, psychiatric medication, heat transfer alloys.", "Lithium is light enough to float on water.", "Johan August Arfwedson", "1817", "Sweden");
            case 4: return new ExtendedData(getBp(num), getMp(num), "Aerospace components, X-ray windows, structural materials.", "Beryllium is highly toxic and can cause berylliosis if inhaled.", "Louis Nicolas Vauquelin", "1798", "France");
            case 5: return new ExtendedData(getBp(num), getMp(num), "Fiberglass, borosilicate glass (Pyrex), detergents.", "Boron is an exceptionally hard metalloid and completely devoid of free electrons.", "Joseph Louis Gay-Lussac", "1808", "France-UK");
            case 6: return new ExtendedData(getBp(num), getMp(num), "Steelmaking, polymers, graphite (pencils, batteries).", "Carbon forms more compounds than any other element, the basis for all known life.", "Known since antiquity", "Ancient", "Global");
            case 7: return new ExtendedData(getBp(num), getMp(num), "Fertilizers, liquid cooling, food preservation.", "Nitrogen gas makes up about 78% of Earth's atmosphere.", "Daniel Rutherford", "1772", "Scotland");
            case 8: return new ExtendedData(getBp(num), getMp(num), "Medical breathing gas, steel production, rocket propellant.", "Oxygen forms about 21% of the Earth's atmosphere and 46% of its crust.", "Carl Wilhelm Scheele", "1771", "Sweden");
            case 9: return new ExtendedData(getBp(num), getMp(num), "Toothpaste, Teflon coatings, uranium enrichment.", "Fluorine is the most electronegative and reactive of all elements.", "Henri Moissan", "1886", "France");
            case 10: return new ExtendedData(getBp(num), getMp(num), "Neon signs, specialized lasers, cryogenics.", "Neon glows a reddish-orange color in a vacuum discharge tube.", "Sir William Ramsay", "1898", "UK");
            case 11: return new ExtendedData(getBp(num), getMp(num), "Table salt, streetlights, heat transfer.", "Sodium reacts violently with water to form hydrogen gas.", "Humphry Davy", "1807", "England");
            case 12: return new ExtendedData(getBp(num), getMp(num), "Lightweight alloys (laptops/cars), fireworks, flares.", "Magnesium burns with an intensely bright white light.", "Joseph Black", "1755", "Scotland");
            case 13: return new ExtendedData(getBp(num), getMp(num), "Aircraft, cans, foil, building materials.", "Aluminum is the most abundant metal in the Earth's crust.", "Hans Christian Ørsted", "1825", "Denmark");
            case 14: return new ExtendedData(getBp(num), getMp(num), "Computer chips, solar cells, glass, cement.", "Silicon comes from the Latin 'silex', meaning flint or hard stone.", "Jöns Jacob Berzelius", "1824", "Sweden");
            case 15: return new ExtendedData(getBp(num), getMp(num), "Fertilizers, matches, explosive compounds.", "White phosphorus famously glows in the dark (phosphorescence).", "Hennig Brand", "1669", "Germany");
            case 16: return new ExtendedData(getBp(num), getMp(num), "Sulfuric acid production, vulcanizing rubber, gunpowder.", "Sulfur makes up part of many foul-smelling compounds like rotten eggs.", "Known since antiquity", "Ancient", "Global");
            case 17: return new ExtendedData(getBp(num), getMp(num), "Water purification, PVC plastics, bleach.", "Chlorine gas was used as a chemical weapon in WWI.", "Carl Wilhelm Scheele", "1774", "Sweden");
            case 18: return new ExtendedData(getBp(num), getMp(num), "Shielding gas for welding, filling incandescent lightbulbs.", "Argon was the first noble gas to be discovered.", "Lord Rayleigh", "1894", "UK");
            case 19: return new ExtendedData(getBp(num), getMp(num), "Fertilizers, soap making, vital human nutrient.", "Potassium is so soft it can be cut with a knife.", "Humphry Davy", "1807", "England");
            case 20: return new ExtendedData(getBp(num), getMp(num), "Bones and teeth, cement, plaster.", "Calcium compounds form beautiful stalactites in caves.", "Humphry Davy", "1808", "England");
            case 26: return new ExtendedData(getBp(num), getMp(num), "Steel making, structural engineering, hemoglobin.", "Iron is the most abundant element (by mass) making up the Earth.", "Known since antiquity", "Ancient", "Global");
            case 29: return new ExtendedData(getBp(num), getMp(num), "Electrical wiring, plumbing, coins, bronze/brass alloys.", "Copper is naturally antibacterial.", "Known since antiquity", "Ancient", "Global");
            case 47: return new ExtendedData(getBp(num), getMp(num), "Jewelry, photography, electronics, mirrors.", "Silver has the highest electrical conductivity of any metal.", "Known since antiquity", "Ancient", "Global");
            case 79: return new ExtendedData(getBp(num), getMp(num), "Jewelry, investments, electronics.", "Gold never tarnishes or rusts because it is unreactive.", "Known since antiquity", "Ancient", "Global");
            case 80: return new ExtendedData(getBp(num), getMp(num), "Thermometers, barometers, fluorescent lamps.", "Mercury is the only metal that is liquid at standard room temperature.", "Known since antiquity", "Ancient", "Global");
            case 82: return new ExtendedData(getBp(num), getMp(num), "Car batteries, radiation shielding, weights.", "Lead was extensively used in ancient Roman plumbing.", "Known since antiquity", "Ancient", "Global");
            case 92: return new ExtendedData(getBp(num), getMp(num), "Nuclear power, nuclear weapons, armor piercing shells.", "One kilogram of uranium-235 theoretically produces about 20 terajoules of energy.", "Martin Heinrich Klaproth", "1789", "Germany");
            default:
                return new ExtendedData(
                    getBp(num), getMp(num),
                    "Primarily used in specialized laboratory research and metallurgical applications.",
                    name + " is a chemical element with complex transitional or radioactive properties.",
                    "Various Researchers", "N/A", "Unknown"
                );
        }
    }
}

