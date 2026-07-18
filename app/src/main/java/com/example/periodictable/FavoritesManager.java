package com.example.periodictable;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public class FavoritesManager {

    private static final String PREF_NAME = "PeriodicTableFavorites";
    private static final String KEY_FAVS = "favorite_elements";

    private SharedPreferences prefs;

    public FavoritesManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public boolean isFavorite(int atomicNumber) {
        Set<String> favs = prefs.getStringSet(KEY_FAVS, new HashSet<>());
        return favs.contains(String.valueOf(atomicNumber));
    }

    public void toggleFavorite(int atomicNumber) {
        Set<String> favs = new HashSet<>(prefs.getStringSet(KEY_FAVS, new HashSet<>()));
        String idStr = String.valueOf(atomicNumber);

        if (favs.contains(idStr)) {
            favs.remove(idStr);
        } else {
            favs.add(idStr);
        }

        prefs.edit().putStringSet(KEY_FAVS, favs).apply();
    }

    public Set<Integer> getFavoriteIds() {
        Set<String> favs = prefs.getStringSet(KEY_FAVS, new HashSet<>());
        Set<Integer> intFavs = new HashSet<>();
        for (String s : favs) {
            intFavs.add(Integer.parseInt(s));
        }
        return intFavs;
    }
}
