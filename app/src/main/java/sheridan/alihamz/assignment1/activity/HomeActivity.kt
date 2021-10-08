package sheridan.alihamz.assignment1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import sheridan.alihamz.assignment1.R
import sheridan.alihamz.assignment1.databinding.ActivityHomeBinding
import sheridan.alihamz.assignment1.fragment.InputFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(InputFragment.newInstance(), false)
    }


    fun loadFragment(fragment: Fragment, isBack: Boolean) {
        val tr = supportFragmentManager.beginTransaction()
        tr.replace(R.id.frameHome, fragment, fragment.javaClass.simpleName)
        if (isBack) {
            tr.addToBackStack(null)
        }
        tr.commit()
    }

}