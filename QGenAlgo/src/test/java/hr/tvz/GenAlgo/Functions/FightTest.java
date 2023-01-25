//package hr.tvz.GenAlgo.Functions;
//
//import hr.tvz.GenAlgo.Model.Stats;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class FightTest {
//
//    @Test
//    @DisplayName("basic fight")
//    void works() {
//        //  a2 should instantly kill a1
//        var a1 = new Stats(100, 1, 1, 1, 1);
//        var a2 = new Stats(1, 1, 100, 10, 1);
//
//        // b1 wins with 3 successive strikes
//        var b1 = new Stats(100, 0.5, 100, 10, 1);
//        var b2 = new Stats(300, 1.5, 10, 1, 1);
//
//        // c2 wins with 3 successive strikes
//        var c1 = new Stats(300, 1.5, 10, 1, 1);
//        var c2 = new Stats(100, 0.5, 100, 10, 1);
//
//        var rA = Fight.fightB(a1, a2);
//        var rB = Fight.fightB(b1, b2);
//        var rC = Fight.fightB(c1, c2);
//
//        assertTrue(rA);
//        assertFalse(rB);
//        assertTrue(rC);
//    }
//}
