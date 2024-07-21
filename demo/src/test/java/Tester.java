import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import testing.Main;

@RunWith(Parameterized.class)

public class Tester {
    private Main tester;
    private int x, y;
    private String expected;

    public Tester(int x, int y, String expected) {
        // 2 input parameters
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

    @Before
    public void setup() {
        tester = new Main();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> valuePairs() {
        return Arrays.asList(new Object[][] {
                // KIỂM THỬ DÒNG ĐIỀU KHIỂN
                { -1201, 3108, "invalid" },
                { 0, 0, "1 2 3 4" },
                { 0, 12, "1 2" },
                { 0, -31, "3 4" },
                { 12, 0, "1 4" },
                { -31, 0, "2 3" },
                { 12, 31, "1" },
                { -31, 12, "2" },
                { -31, -12, "3" },
                { 12, -31, "4" }

                // KIỂM THỬ GIÁ TRỊ BIÊN
                // 1 & \multirow{7}{*}{$nom$} & $min^{-}$ & 0 -1001 & invalid \\ \cline{1-1}
                // \cline{3-5}
                // 2 & & $min$ & 0 -1000 & 3 4 \\ \cline{1-1} \cline{3-5}
                // 3 & & $min^{+}$ & 0 -999 & 3 4 \\ \cline{1-1} \cline{3-5}
                // 4 & & $nom$ & 0 0 & 1 2 3 4 \\ \cline{1-1} \cline{3-5}
                // 5 & & $max^{-}$ & 0 999 & 1 2 \\ \cline{1-1} \cline{3-5}
                // 6 & & $max$ & 0 1000 & 1 2 \\ \cline{1-1} \cline{3-5}
                // 7 & & $max^{+}$ & 0 1001 & invalid \\ \hline
                // 8 & $min^{-}$ & \multirow{6}{*}{$nom$} & -1001 0 & invalid \\ \cline{1-2}
                // \cline{4-5}
                // 9 & $min$ & & -1000 0 & 2 3 \\ \cline{1-2} \cline{4-5}
                // 10 & $min^{+}$ & & -999 0 & 2 3 \\ \cline{1-2} \cline{4-5}
                // 11 & $max^{-}$ & & 999 0 & 1 4 \\ \cline{1-2} \cline{4-5}
                // 12 & $max$ & & 1000 0 & 1 4 \\ \cline{1-2} \cline{4-5}
                // 13 & $max^{+}$ & & 1001 0 & invalid \\ \hline

                // \textbf{STT} & \multicolumn{1}{c|}{\textbf{Đầu vào $x$}} &
                // \multicolumn{1}{c|}{\textbf{Đầu vào $y$}} & \multicolumn{1}{c|}{\textbf{Đầu
                // ra kỳ vọng}} \\ \hline
                // 1 & 12 & 31 & 1 \\ \hline
                // 2 & -12 & 31 & 2 \\ \hline
                // 3 & -12 & -31 & 3 \\ \hline
                // 4 & 12 & -31 & 4 \\ \hline

                // { 0, -1001, "invalid" }, { 0, -1000, "3 4" }, { 0, -999, "3 4" }, { 0, 0, "1
                // 2 3 4" },
                // { 0, 999, "1 2" }, { 0, 1000, "1 2" }, { 0, 1001, "invalid" }, { -1001, 0,
                // "invalid" },
                // { -1000, 0, "2 3" }, { -999, 0, "2 3" }, { 999, 0, "1 4" }, { 1000, 0, "1 4"
                // }, { 1001, 0, "invalid" },
                // { 12, 31, "1" }, { -12, 31, "2" }, { -12, -31, "3" }, { 12, -31, "4" }

                // KIỂM THỬ BẢNG QUYẾT ĐỊNH
                // R1 & -3108 & 1201 & invalid \\ \hline
                // R2 & -3108 & 0 & invalid \\ \hline
                // R3 & -3108 & -12 & invalid \\ \hline
                // R4 & -1201 & 31 & invalid \\ \hline
                // R5 & 0 & 1201 & invalid \\ \hline
                // R6 & 0 & 0 & 1 2 3 4 \\ \hline
                // R7 & 0 & -12 & 3 4 \\ \hline
                // R8 & 0 & 31 & 1 2 \\ \hline
                // R9 & -12 & 3108 & invalid \\ \hline
                // R10 & -12 & 0 & 2 3 \\ \hline
                // R11 & -12 & -31 & 3 \\ \hline
                // R12 & -12 & 31 & 2 \\ \hline
                // R13 & 31 & -1201 & invalid \\ \hline
                // R14 & 31 & 0 & 1 4 \\ \hline
                // R15 & 31 & -12 & 4 \\ \hline
                // R16 & 31 & 12 & 1 \\ \hline

                // { -3108, 1201, "invalid" }, { -3108, 0, "invalid" }, { -3108, -12, "invalid" },
                // { -1201, 31, "invalid" }, { 0, 1201, "invalid" }, { 0, 0, "1 2 3 4" }, { 0, -12, "3 4" },
                // { 0, 31, "1 2" }, { -12, 3108, "invalid" }, { -12, 0, "2 3" }, { -12, -31, "3" },
                // { -12, 31, "2" }, { 31, -1201, "invalid" }, { 31, 0, "1 4" }, { 31, -12, "4" },
                // { 31, 12, "1" }
        });
    }

    @Test
    public void test() {
        assertEquals(expected, Main.checkQuadrant(x, y));
    }
}