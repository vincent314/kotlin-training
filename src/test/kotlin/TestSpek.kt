import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object TestSpek: Spek({
    describe("First test"){
        it("should pass"){
            true shouldBe true
        }
    }
})