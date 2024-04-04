package com.syntax_institut.whatssyntax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val calls = Datasource().getCalls()
    val chats = Datasource().getChats()
    val contacts = Datasource().getContacts().sortedBy { it.status == null }
    val profile = Datasource().getProfile()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // API
        // https://fakenews.squirro.com/news/entertainment
        // https://fakenews.squirro.com/news/entertainment?count=25

        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        binding.bottomNav.setupWithNavController(navHost.navController)
    }
}