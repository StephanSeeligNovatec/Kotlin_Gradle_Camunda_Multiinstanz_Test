package my.multiinstanz

import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

/** Process constants. */
object Process {
    const val P1_BASE = "P1_Process_Base"
    const val P2_WITH_MIC_BEFORE = "P2_Process_With_MIC_BEFORE"
    const val P3_WITHOUT_MIC = "P3_Process_Without_MIAC"
    const val P4_WITH_AC_BEFOREundAFTER_With_MIAC_BEFORE = "P4_Process_With_AC_BEFOREundAFTER_With_MIAC_BEFORE"
    const val P5_WITHOUT_MIAC_With_AC_BEFOREundAFTER = "P5_Process_Without_MIAC_With_AC_BEFOREundAFTER"
    const val P6_Process_Exception_Test = "P6_Process_Exception_Test"


    /** Activity IDs of [Process]. */
    object ActivityIds {
        const val CREATE_SHOPPING_LIST = "CreateShoppingList"
        const val PREPARE_MEANS_OF_PAYMENT = "PrepareMeansOfPayment"
        const val PREPARE_CART_DEPOSIT = "PrepareShoppingCartDeposit"
        const val PREPARE_SHOPPING_COMPLETED = "PrepareShoppingCompleted"
        const val TAKE_CART = "TakeShoppingCart"
        const val CHOOSE_GOODS = "ChooseGoods#multiInstanceBody"
        const val PAY_GOODS = "PayGoods"
        const val CREATE_NEW_SHOPPING_LIST = "CreateNewShoppingList"
        const val SHOPPING_COMPLETED = "PerformShoppingCompleted"
        const val COMPLETED = "ShoppingCompleted"
        const val PREPARATION_FAILED = "ShoppingPreparationFailure"
        const val SHOPPING_FAILED = "ShoppingFailed"
    }

    object ErrorCodes {
        const val ERROR_BAD_ITEM = "ERROR"
    }

    /** Variable names of the [Process]. */
    object Variables {
        /** List of names of all goods which are to be bought. */
        const val SHOPPING_LIST = "shoppingList"

        const val SHOPPING_ITEM = "shoppingItem"

        /** All [Variables]. */
        val ALL: List<String> =
            Variables::class.memberProperties.filter { it.isAccessible }.map { it.name }
    }
}