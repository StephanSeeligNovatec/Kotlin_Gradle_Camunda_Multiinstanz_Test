package my.multiinstanz.rest

import my.multiinstanz.Process
import my.multiinstanz.delegate.MultiInstanzDelegate
import org.camunda.bpm.engine.RuntimeService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class StartController(private val runtimeService: RuntimeService) {

    @PostMapping("/start")
    fun startProcess(@RequestBody inputData: InputData) {

        log.info("Starting process with list: ${inputData.shoppingItems}")

        for (processId in inputData.processIds) {
            runtimeService.startProcessInstanceByKey(
                getProcess(processId),
                mapOf(Process.Variables.SHOPPING_LIST to inputData.shoppingItems)
            )
        }

    }

    fun getProcess(prozessId: String) : String {
        return when(prozessId) {
            "P1" -> Process.P1_BASE
            "P2" -> Process.P2_WITH_MIC_BEFORE
            "P3" -> Process.P3_WITHOUT_MIC
            "P4" -> Process.P4_WITH_AC_BEFOREundAFTER_With_MIAC_BEFORE
            "P5" -> Process.P5_WITHOUT_MIAC_With_AC_BEFOREundAFTER
            "P6" -> Process.P6_Process_Exception_Test
            else -> ""
        }
    }


    companion object {
        private val log = LoggerFactory.getLogger(MultiInstanzDelegate::class.java)
    }
}

class InputData {
    lateinit var shoppingItems: List<String>
    lateinit var processIds: List<String>
}