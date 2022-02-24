package my.multiinstanz.delegate

import my.multiinstanz.ForbiddenItemBpmnError
import my.multiinstanz.Process
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MultiInstanzDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution?) {
        val shoppingItem = execution?.getVariable(Process.Variables.SHOPPING_ITEM)
        log.info("Delegate runs for $shoppingItem")

        when (shoppingItem) {
            "Hund" -> throw RuntimeException("Exception item $shoppingItem not allowed")
            // Hiermit wird die MultiInstanz abgebrochen
            //"Brot" -> throw ForbiddenItemBpmnError(Process.ErrorCodes.ERROR_BAD_ITEM, "You shopping for a forbidden item")
            //"Liebe" -> throw ForbiddenItemBpmnError(Process.ErrorCodes.ERROR_BAD_ITEM, "You shopping for a forbidden item")
        }

        log.info("Delegate with id {} done", execution?.processInstanceId)
    }

    companion object {
        private val log = LoggerFactory.getLogger(MultiInstanzDelegate::class.java)
    }

    //https://docs.camunda.org/manual/7.12/user-guide/process-engine/the-job-executor/#exclusive-jobs
    //https://docs.camunda.org/manual/7.16/user-guide/process-engine/the-job-executor/#use-a-custom-job-retry-configuration-for-multi-instance-activities
}