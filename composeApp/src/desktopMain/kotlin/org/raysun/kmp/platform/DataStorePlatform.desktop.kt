package org.raysun.kmp.platform

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences

val delegate: Preferences = Preferences.userRoot()

actual val settings: Settings = PreferencesSettings(delegate)