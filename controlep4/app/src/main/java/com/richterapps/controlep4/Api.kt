package com.richterapps.controlep4

object Api {
    private const val ROOT_URL = "http://192.168.44.108/consumo/Api.php?g="
    const val URL_CREATE_MATERIAL = ROOT_URL + "createmat"
    const val URL_READ_MATERIAL = ROOT_URL + "getmat"
    const val URL_UPDATE_MATERIAL = ROOT_URL + "updatemat"
    const val URL_DELETE_MATERIAL = ROOT_URL + "deletemat&id="
    const val URL_BUSCA_MATERIAL = ROOT_URL + "buscamat&codigo="
}