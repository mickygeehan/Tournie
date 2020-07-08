package com.michael.g.tournie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType

class CustomAppIntro : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransformer(AppIntroPageTransformerType.Depth)
        setImmersiveMode()

        addSlide(AppIntroFragment.newInstance(
            title = "Welcome",
            description = "This is the first slide :)"
        ))

        addSlide(AppIntroFragment.newInstance(
            title = "Next",
            description = "Second and last"
        ))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        introShown()
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        introShown()
        finish()
    }

    private fun introShown() {
        val sharedPref = getSharedPreferences(getString(R.string.shared_preferences_file_key),Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean(getString(R.string.intro_shown_key), true)
            commit()
        }
    }

}
