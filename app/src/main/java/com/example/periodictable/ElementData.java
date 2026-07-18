package com.example.periodictable;
import java.util.ArrayList;

public class ElementData {
    public static ArrayList<Element> getElements() {
        ArrayList<Element> list = new ArrayList<>();

        for(int i = 1; i <= 18; i++) {
            list.add(new Element(String.valueOf(i), 0, i));
        }

        for(int i = 1; i <= 7; i++) {
            list.add(new Element(String.valueOf(i), i, 0));
        }

        // --- Row 0 (Period 1) ---
        list.add(new Element(1, "H", "Hydrogen", "1.008", 0, 0));
        list.add(new Element(2, "He", "Helium", "4.0026", 0, 17));

        // --- Row 1 (Period 2) ---
        list.add(new Element(3, "Li", "Lithium", "6.94", 1, 0));
        list.add(new Element(4, "Be", "Beryllium", "9.0122", 1, 1));
        list.add(new Element(5, "B", "Boron", "10.81", 1, 12));
        list.add(new Element(6, "C", "Carbon", "12.011", 1, 13));
        list.add(new Element(7, "N", "Nitrogen", "14.007", 1, 14));
        list.add(new Element(8, "O", "Oxygen", "15.999", 1, 15));
        list.add(new Element(9, "F", "Fluorine", "18.998", 1, 16));
        list.add(new Element(10, "Ne", "Neon", "20.180", 1, 17));

        // --- Row 2 (Period 3) ---
        list.add(new Element(11, "Na", "Sodium", "22.990", 2, 0));
        list.add(new Element(12, "Mg", "Magnesium", "24.305", 2, 1));
        list.add(new Element(13, "Al", "Aluminum", "26.982", 2, 12));
        list.add(new Element(14, "Si", "Silicon", "28.085", 2, 13));
        list.add(new Element(15, "P", "Phosphorus", "30.974", 2, 14));
        list.add(new Element(16, "S", "Sulfur", "32.06", 2, 15));
        list.add(new Element(17, "Cl", "Chlorine", "35.45", 2, 16));
        list.add(new Element(18, "Ar", "Argon", "39.948", 2, 17));

        // --- Row 3 (Period 4) ---
        list.add(new Element(19, "K", "Potassium", "39.098", 3, 0));
        list.add(new Element(20, "Ca", "Calcium", "40.078", 3, 1));
        list.add(new Element(21, "Sc", "Scandium", "44.956", 3, 2));
        list.add(new Element(22, "Ti", "Titanium", "47.867", 3, 3));
        list.add(new Element(23, "V", "Vanadium", "50.942", 3, 4));
        list.add(new Element(24, "Cr", "Chromium", "51.996", 3, 5));
        list.add(new Element(25, "Mn", "Manganese", "54.938", 3, 6));
        list.add(new Element(26, "Fe", "Iron", "55.845", 3, 7));
        list.add(new Element(27, "Co", "Cobalt", "58.933", 3, 8));
        list.add(new Element(28, "Ni", "Nickel", "58.693", 3, 9));
        list.add(new Element(29, "Cu", "Copper", "63.546", 3, 10));
        list.add(new Element(30, "Zn", "Zinc", "65.38", 3, 11));
        list.add(new Element(31, "Ga", "Gallium", "69.723", 3, 12));
        list.add(new Element(32, "Ge", "Germanium", "72.63", 3, 13));
        list.add(new Element(33, "As", "Arsenic", "74.922", 3, 14));
        list.add(new Element(34, "Se", "Selenium", "78.971", 3, 15));
        list.add(new Element(35, "Br", "Bromine", "79.904", 3, 16));
        list.add(new Element(36, "Kr", "Krypton", "83.798", 3, 17));

        // --- Row 4 (Period 5) ---
        list.add(new Element(37, "Rb", "Rubidium", "85.468", 4, 0));
        list.add(new Element(38, "Sr", "Strontium", "87.62", 4, 1));
        list.add(new Element(39, "Y", "Yttrium", "88.906", 4, 2));
        list.add(new Element(40, "Zr", "Zirconium", "91.224", 4, 3));
        list.add(new Element(41, "Nb", "Niobium", "92.906", 4, 4));
        list.add(new Element(42, "Mo", "Molybdenum", "95.95", 4, 5));
        list.add(new Element(43, "Tc", "Technetium", "(98)", 4, 6));
        list.add(new Element(44, "Ru", "Ruthenium", "101.07", 4, 7));
        list.add(new Element(45, "Rh", "Rhodium", "102.91", 4, 8));
        list.add(new Element(46, "Pd", "Palladium", "106.42", 4, 9));
        list.add(new Element(47, "Ag", "Silver", "107.87", 4, 10));
        list.add(new Element(48, "Cd", "Cadmium", "112.41", 4, 11));
        list.add(new Element(49, "In", "Indium", "114.82", 4, 12));
        list.add(new Element(50, "Sn", "Tin", "118.71", 4, 13));
        list.add(new Element(51, "Sb", "Antimony", "121.76", 4, 14));
        list.add(new Element(52, "Te", "Tellurium", "127.60", 4, 15));
        list.add(new Element(53, "I", "Iodine", "126.90", 4, 16));
        list.add(new Element(54, "Xe", "Xenon", "131.29", 4, 17));

        list.add(new Element(55, "Cs", "Cesium", "132.91", 5, 0));
        list.add(new Element(56, "Ba", "Barium", "137.33", 5, 1));
        list.add(new Element(true, "57 - 71", "Lanthanoids", 5, 2));


        list.add(new Element(72, "Hf", "Hafnium", "178.49", 5, 3));
        list.add(new Element(73, "Ta", "Tantalum", "180.95", 5, 4));
        list.add(new Element(74, "W", "Tungsten", "183.84", 5, 5));
        list.add(new Element(75, "Re", "Rhenium", "186.21", 5, 6));
        list.add(new Element(76, "Os", "Osmium", "190.23", 5, 7));
        list.add(new Element(77, "Ir", "Iridium", "192.22", 5, 8));
        list.add(new Element(78, "Pt", "Platinum", "195.08", 5, 9));
        list.add(new Element(79, "Au", "Gold", "196.97", 5, 10));
        list.add(new Element(80, "Hg", "Mercury", "200.59", 5, 11));
        list.add(new Element(81, "Tl", "Thallium", "204.38", 5, 12));
        list.add(new Element(82, "Pb", "Lead", "207.2", 5, 13));
        list.add(new Element(83, "Bi", "Bismuth", "208.98", 5, 14));
        list.add(new Element(84, "Po", "Polonium", "(209)", 5, 15));
        list.add(new Element(85, "At", "Astatine", "(210)", 5, 16));
        list.add(new Element(86, "Rn", "Radon", "(222)", 5, 17));

        list.add(new Element(87, "Fr", "Francium", "(223)", 6, 0));
        list.add(new Element(88, "Ra", "Radium", "(226)", 6, 1));
        list.add(new Element(true, "89 - 103", "Actinoids", 6, 2));


        list.add(new Element(104, "Rf", "Rutherfordium", "(267)", 6, 3));
        list.add(new Element(105, "Db", "Dubnium", "(270)", 6, 4));
        list.add(new Element(106, "Sg", "Seaborgium", "(271)", 6, 5));
        list.add(new Element(107, "Bh", "Bohrium", "(270)", 6, 6));
        list.add(new Element(108, "Hs", "Hassium", "(277)", 6, 7));
        list.add(new Element(109, "Mt", "Meitnerium", "(276)", 6, 8));
        list.add(new Element(110, "Ds", "Darmstadtium", "(281)", 6, 9));
        list.add(new Element(111, "Rg", "Roentgenium", "(280)", 6, 10));
        list.add(new Element(112, "Cn", "Copernicium", "(285)", 6, 11));
        list.add(new Element(113, "Nh", "Nihonium", "(284)", 6, 12));
        list.add(new Element(114, "Fl", "Flerovium", "(289)", 6, 13));
        list.add(new Element(115, "Mc", "Moscovium", "(288)", 6, 14));
        list.add(new Element(116, "Lv", "Livermorium", "(293)", 6, 15));
        list.add(new Element(117, "Ts", "Tennessine", "(294)", 6, 16));
        list.add(new Element(118, "Og", "Oganesson", "(294)", 6, 17));

        // --- LANTHANIDES (Row 7) ---
        list.add(new Element(57, "La", "Lanthanum", "138.91", 7, 2));
        list.add(new Element(58, "Ce", "Cerium", "140.12", 7, 3));
        list.add(new Element(59, "Pr", "Praseodymium", "140.91", 7, 4));
        list.add(new Element(60, "Nd", "Neodymium", "144.24", 7, 5));
        list.add(new Element(61, "Pm", "Promethium", "(145)", 7, 6));
        list.add(new Element(62, "Sm", "Samarium", "150.36", 7, 7));
        list.add(new Element(63, "Eu", "Europium", "151.96", 7, 8));
        list.add(new Element(64, "Gd", "Gadolinium", "157.25", 7, 9));
        list.add(new Element(65, "Tb", "Terbium", "158.93", 7, 10));
        list.add(new Element(66, "Dy", "Dysprosium", "162.50", 7, 11));
        list.add(new Element(67, "Ho", "Holmium", "164.93", 7, 12));
        list.add(new Element(68, "Er", "Erbium", "167.26", 7, 13));
        list.add(new Element(69, "Tm", "Thulium", "168.93", 7, 14));
        list.add(new Element(70, "Yb", "Ytterbium", "173.05", 7, 15));
        list.add(new Element(71, "Lu", "Lutetium", "174.97", 7, 16));

        // --- ACTINIDES (Row 8) ---
        list.add(new Element(89, "Ac", "Actinium", "(227)", 8, 2));
        list.add(new Element(90, "Th", "Thorium", "232.04", 8, 3));
        list.add(new Element(91, "Pa", "Protactinium", "231.04", 8, 4));
        list.add(new Element(92, "U", "Uranium", "238.03", 8, 5));
        list.add(new Element(93, "Np", "Neptunium", "(237)", 8, 6));
        list.add(new Element(94, "Pu", "Plutonium", "(244)", 8, 7));
        list.add(new Element(95, "Am", "Americium", "(243)", 8, 8));
        list.add(new Element(96, "Cm", "Curium", "(247)", 8, 9));
        list.add(new Element(97, "Bk", "Berkelium", "(247)", 8, 10));
        list.add(new Element(98, "Cf", "Californium", "(251)", 8, 11));
        list.add(new Element(99, "Es", "Einsteinium", "(252)", 8, 12));
        list.add(new Element(100, "Fm", "Fermium", "(257)", 8, 13));
        list.add(new Element(101, "Md", "Mendelevium", "(258)", 8, 14));
        list.add(new Element(102, "No", "Nobelium", "(259)", 8, 15));
        list.add(new Element(103, "Lr", "Lawrencium", "(262)", 8, 16));

        return list;
    }
}
