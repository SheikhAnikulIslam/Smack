package com.example.hanyr.smack.Utilities

import java.net.URL

/**
 * Created by Hanyr on 19-Jan-18.
 */
const val BASE_URL = "https://smackchatapps.herokuapp.com/v1/"
const val SOCKEt_URL = "https://smackchatapps.herokuapp.com/"
const val URL_REGISTER = "${BASE_URL}account/register"
const val URL_LOGIN = "${BASE_URL}account/login"
const val URL_CREATE_USER = "${BASE_URL}user/add"
const val URL_GET_USER = "${BASE_URL}user/byEmail/"
const val URL_GET_CHANNELS = "${BASE_URL}channel/"
const val URL_GET_MESSAGES = "${BASE_URL}message/byChannel/"

//Broadcast Constants
const val BROADCAST_USER_DATA_CHANGE = "BROADCAST_USER_DATA_CHANGE"