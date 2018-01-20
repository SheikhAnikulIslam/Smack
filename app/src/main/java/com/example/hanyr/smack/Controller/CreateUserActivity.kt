package com.example.hanyr.smack.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hanyr.smack.R
import com.example.hanyr.smack.Services.AuthServices
import com.example.hanyr.smack.Services.UserDataService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun GenerateUserAvatar(view: View){
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        if (color == 0){
            userAvatar = "light$avatar"
        }else{
            userAvatar = "dark$avatar"
        }

        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        CreateAvatarImageView.setImageResource(resourceId)
    }
    fun CreateUserClicked(view: View){
        val UserName = CreateUserNameText.text.toString()
        val Email = CreateEmailText.text.toString()
        val Password = CreatePasswordText.text.toString()
        AuthServices.registerUser(this, Email, Password){registerSuccess ->
            if (registerSuccess){
                AuthServices.loginUser(this, Email, Password){loginSuccess ->
                    if (loginSuccess){
                        AuthServices.createUser(this, UserName, Email, userAvatar, avatarColor){createSuccess ->
                            if (createSuccess){
                                println(UserDataService.avatarName)
                                println(UserDataService.avatarColor)
                                println(UserDataService.name)
                                finish()
                            }
                        }
                    }
                }
            }
        }
    }

    fun GenerateColorClicked(view: View){
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        CreateAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"
        println(avatarColor)
    }
}
