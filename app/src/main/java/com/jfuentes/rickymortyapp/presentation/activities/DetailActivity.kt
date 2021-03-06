package com.jfuentes.rickymortyapp.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.databinding.ActivityDetailBinding
import com.jfuentes.rickymortyapp.domain.model.Character
import com.jfuentes.rickymortyapp.domain.usecase.AddCharacterToFavouriteUseCase
import com.jfuentes.rickymortyapp.domain.usecase.ExistIdFavouriteUseCase
import com.jfuentes.rickymortyapp.domain.usecase.RemoveItemFromFavouriteUseCase
import com.jfuentes.rickymortyapp.presentation.viewmodel.CharacterDetailVM
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {

    private val getFavByIdFavouriteUseCase :ExistIdFavouriteUseCase by inject()
    private val addFavouriteCharacter : AddCharacterToFavouriteUseCase by inject()
    private val removeItemFromFavouriteUseCase : RemoveItemFromFavouriteUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val character: Character =
            requireNotNull(intent.extras?.character) { "Illegal opening, we need Character data to open detail screen" }
        binding.model = CharacterDetailVM(
            character,
            getFavByIdFavouriteUseCase,
            addFavouriteCharacter,
            removeItemFromFavouriteUseCase
        )
    }

    companion object {

        private const val EXTRA_CHARACTER_ID = "detail.extra.character"

        @JvmStatic
        fun getCallingIntent(context: Context, character: Character) =
            Intent(context, DetailActivity::class.java).also {
                it.putExtras(Bundle().apply { this.character = character })
            }

        private var Bundle.character: Character?
            get() = getParcelable(EXTRA_CHARACTER_ID)
            set(value) {
                putParcelable(EXTRA_CHARACTER_ID, value)
            }
    }
}