/**
 * Copyright (C) 2013-2015 Stéphane Péchard.
 *
 * This file is part of PhotoBackup.
 *
 * PhotoBackup is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PhotoBackup is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package fr.s13d.photobackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PBBootBroadcastReceiver extends BroadcastReceiver {

    private static final String LOG_TAG = "PBBootBroadcastReceiver";

    @Override
	public void onReceive(final Context context, final Intent intent) {

		final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		final boolean running = preferences.getBoolean(PBSettingsFragment.PREF_SERVICE_RUNNING, false);
		if (running) {
			final Intent startServiceIntent = new Intent(context, PBService.class);
			context.startService(startServiceIntent);
		}
	}

}
