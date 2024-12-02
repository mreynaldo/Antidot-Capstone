import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class SessionManager(context: Context) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val prefs: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        "user_session",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_TOKEN = "token"
        private const val KEY_SESSION_TIMESTAMP = "session_timestamp"
    }

    fun saveSession(token: String) {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_TOKEN, token)
            apply()
        }
    }

    fun isSessionExpired(timeoutMillis: Long): Boolean {
        val timestamp = prefs.getLong(KEY_SESSION_TIMESTAMP, 0L)
        return System.currentTimeMillis() - timestamp > timeoutMillis
    }

    fun clearSession() {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, false)
            remove(KEY_TOKEN)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    fun getToken(): String? = prefs.getString(KEY_TOKEN, null)
}
