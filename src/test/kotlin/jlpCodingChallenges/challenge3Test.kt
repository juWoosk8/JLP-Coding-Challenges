package jlpCodingChallenges

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class SokobanMoveTest {

    @Test

    fun `should return unchanged array when move is illegal `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#p        * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "q"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#p        * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return unchanged array when move is left and left char is # `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#p        * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#p        * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array when move is left and left char is space `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "# p       * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#p        * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with P when move is left and left char is * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*p         #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#P          #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with b moved when move is left and left char is b `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#     bp b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#    bp  b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is left and left char is b against a wall `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#bp      b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#bp      b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is left and left char is b against a box `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#bbp     b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#bbp     b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return changed array with b moved when move is left and left char is b against a * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#*bp     b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#Bp      b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array when move is right and right char is # `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#         *p#",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#         *p#",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array when move is right and right char is space `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "# p       * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#  p      * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with P when move is right and right char is * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "# p*        #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#  P        #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with b moved when move is right and right char is b `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#     pb b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#      pbb  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is right and right char is b against a wall `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#        bpb#",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#        bpb#",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is right and right char is b against a box `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#   b    pbb#",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#   b    pbb#",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return changed array with b moved when move is right and right char is b against a * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "# pb*    b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#  pB    b  #",
                "# *         #",
                "#############"
            )
        )
    }

}
internal class SokobanMoveTest2 {
    @Test
    fun `should return unchanged array when move is down and down char is # `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#         * #",
                "#     b  b  #",
                "# *p        #",
                "#############"
            ), "D"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#         * #",
                "#     b  b  #",
                "# *p        #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array when move is left and left char is space `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "# p       * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#p        * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with P when move is left and left char is * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*p         #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#P          #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with b moved when move is left and left char is b `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#     bp b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#    bp  b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is left and left char is b against a wall `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#bp      b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#bp      b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is left and left char is b against a box `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#bbp     b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#bbp     b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return changed array with b moved when move is left and left char is b against a * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#*bp     b  #",
                "# *         #",
                "#############"
            ), "L"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#Bp      b  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array when move is right and right char is # `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#         *p#",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#         *p#",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array when move is right and right char is space `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "# p       * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#  p      * #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with P when move is right and right char is * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "# p*        #",
                "#     b  b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#  P        #",
                "#     b  b  #",
                "# *         #",
                "#############"
            )
        )
    }

    @Test
    fun `should return changed array with b moved when move is right and right char is b `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#     pb b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#      pbb  #",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is right and right char is b against a wall `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#        bpb#",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#        bpb#",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return unchanged array with b moved when move is right and right char is b against a box `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "#   b    pbb#",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#   b    pbb#",
                "# *         #",
                "#############"
            )
        )
    }
    @Test
    fun `should return changed array with b moved when move is right and right char is b against a * `() {
        val result = processSokobanMove(
            arrayOf(
                "#############",
                "#*          #",
                "# pb*    b  #",
                "# *         #",
                "#############"
            ), "R"
        )
        assertThat(result).isEqualTo(
            arrayOf(
                "#############",
                "#*          #",
                "#  pB    b  #",
                "# *         #",
                "#############"
            )
        )
    }

}