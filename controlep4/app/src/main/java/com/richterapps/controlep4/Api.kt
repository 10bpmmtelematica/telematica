package com.richterapps.controlep4

object Api {
    private const val ROOT_URL = "http://192.168.44.108/consumo/Api.php?g="
    const val URL_CREATE_HERO = ROOT_URL + "createmat"
    const val URL_READ_HEROES = ROOT_URL + "getmat"
    const val URL_UPDATE_HERO = ROOT_URL + "updatemat"
    const val URL_DELETE_HERO = ROOT_URL + "deletemat&id="
    const val URL_BUSCA_HERO = ROOT_URL + "buscamat&codigo="
}