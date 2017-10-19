package swd;

import core.truyentranh8.TruyenTranh8;

public class Main {

    private static String debugHTML = "><div itemprop=\"reviews\" itemscope=\"\" itemtype=\"http://schema" +
            ".org/AggregateRating\"><meta itemprop=\"ratingValue\" content=\"4\"><meta itemprop=\"bestRating\" " +
            "content=\"5\"><meta itemprop=\"ratingCount\" content=\"250\"></div><meta itemprop=\"startDate\" " +
            "datetime=\"2014-07-08 05:33:32\"><meta itemprop=\"contributor\" content=\"noname99\"><div " +
            "class=\"contents\"><h1 itemprop=\"Breadcrumbs\"><a " +
            "href=\"http://m.truyentranh8.net//\" title=\"Truyện &quot;bungaku Shoujo&quot; To Shi Ni Tagari No Douke" +
            " \">\"bungaku Shoujo\" To Shi Ni Tagari No Douke</a></h1><div class=\"navigation\"><select " +
            "name=\"selectChapter\" id=\"selectChapter\" class=\"selectChapter mangaselecter form-control\"><option " +
            "label=\"17\" value=\"17\" selected=\"selected\">17</option><option label=\"15\" " +
            "value=\"15\">15</option><option label=\"14\" value=\"14\">14</option><option label=\"13\" " +
            "value=\"13\">13</option><option label=\"12\" value=\"12\">12</option><option label=\"11\" " +
            "value=\"11\">11</option><option label=\"10\" value=\"10\">10</option><option label=\"9\" " +
            "value=\"9\">9</option><option label=\"8\" value=\"8\">8</option><option label=\"7\" " +
            "value=\"7\">7</option><option label=\"6\" value=\"6\">6</option><option label=\"5\" " +
            "value=\"5\">5</option><option label=\"4\" value=\"4\">4</option><option label=\"3\" " +
            "value=\"3\">3</option><option label=\"1\" value=\"1\">1</option></select><h3>Tăng tốc tải " +
            "trang</h3><select name=\"toiUuLoad\" id=\"toiUuLoad\" class=\"toiUuLoad form-control\"><option " +
            "value=\"360\">Mức 1. Tải siêu tốc, truyện kém</option><option value=\"560\" selected=\"selected\">Mức 2." +
            " Tự động</option><option value=\"640\">Mức 3. Tải hơi nhanh, truyện vừa đủ xem</option><option " +
            "value=\"800\">Mức 4. Truyện đẹp, tải chậm</option><option value=\"-1\">Không tối ưu, truyện gốc, tải " +
            "nhanh chậm tùy mạng</option></select></div><div class=\"clear\" id=\"aCurr\"></div></div><p " +
            "class=\"text-center\"><a " +
            "href=\"http://m.truyentranh8.net/bungaku-shoujo-to-shi-ni-tagari-no-douke-chap-15\" class=\"btn " +
            "btn-primary\">&lt; Chap trước</a></p><div id=\"bs_mobileinpage\"><p></p><p></p><p></p><p></p></div><div " +
            "class=\"center-block text-center\"><div id=\"wrapper\" class=\"row\"> Trang 1/22 <p " +
            "id=\"image_0\"></p><div id=\"image_0\"><img src=\"http://4.bp.blogspot" +
            ".com/-TvqJcZgLKGQ/VZlElB2G1hI/AAAAAAAFHPQ/_ELeSEGRviE/w700/credit.png\" class=\"lazy\" " +
            "id=\"img0\"></div><br>Trang 2/22<div id=\"image_1\"><img src=\"http://1.bp.blogspot" +
            ".com/-7D0fHmiAKYA/VuLm5k8InKI/AAAAAAAM_HQ/MrN8GdcH63o/s0/bt4039-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-00.png?imgmax=0\" class=\"lazy\" id=\"img1\"></div><br>Trang 3/22<div id=\"image_2\"><img " +
            "src=\"http://1.bp.blogspot.com/-kwbiHHdeMsA/VuLm7HEq1cI/AAAAAAAM_HU/mzQksT7_2uA/s0/bt4044" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-01.jpg?imgmax=0\" class=\"lazy\" id=\"img2\"></div><br>Trang " +
            "4/22<div id=\"image_3\"><img src=\"http://1.bp.blogspot" +
            ".com/-Ekvz49fYiTY/VuLm8coFuII/AAAAAAAM_HY/0VMByEqfBpk/s0/bt4049-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-02.jpg?imgmax=0\" class=\"lazy\" id=\"img3\"></div><br>Trang 5/22<div id=\"image_4\"><img " +
            "src=\"http://1.bp.blogspot.com/-urq8of35yYY/VuLm-EddyMI/AAAAAAAM_Hc/SN7GwlQZw6I/s0/bt4055" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-03.jpg?imgmax=0\" class=\"lazy\" id=\"img4\"></div><br>Trang " +
            "6/22<div id=\"image_5\"><img src=\"http://1.bp.blogspot" +
            ".com/-JcXYMG7qEOI/VuLm_X6PaXI/AAAAAAAM_Hg/AcNFtUW3SS0/s0/bt4101-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-04.jpg?imgmax=0\" class=\"lazy\" id=\"img5\"></div><br>Trang 7/22<div id=\"image_6\"><img " +
            "src=\"http://1.bp.blogspot.com/-RM8x6UASmuE/VuLnBdA0G1I/AAAAAAAM_Hk/ANGff6MZ_R0/s0/bt4107" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-05.png?imgmax=0\" class=\"lazy\" id=\"img6\"></div><br>Trang " +
            "8/22<div id=\"image_7\"><img src=\"http://1.bp.blogspot" +
            ".com/-XI-q3Q2Pflg/VuLnDPID-fI/AAAAAAAM_Ho/Uydn8Y5neEo/s0/bt4115-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-06.png?imgmax=0\" class=\"lazy\" id=\"img7\"></div><br>Trang 9/22<div id=\"image_8\"><img " +
            "src=\"http://1.bp.blogspot.com/-ldbu6whtyjc/VuLnFLCQw5I/AAAAAAAM_Hs/2I9jANqxgYk/s0/bt4123" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-07.png?imgmax=0\" class=\"lazy\" id=\"img8\"></div><br>Trang " +
            "10/22<div id=\"image_9\"><img src=\"http://1.bp.blogspot" +
            ".com/-N_siw5X1mrE/VuLnG8uSggI/AAAAAAAM_Hw/kfmeu8f8Rtc/s0/bt4130-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-08.png?imgmax=0\" class=\"lazy\" id=\"img9\"></div><br>Trang 11/22<div id=\"image_10\"><img " +
            "src=\"http://1.bp.blogspot.com/-MoygJRcjQ6k/VuLnIbO_YeI/AAAAAAAM_H0/sp0TuNJGw1U/s0/bt4136" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-09.png?imgmax=0\" class=\"lazy\" id=\"img10\"></div><br>Trang " +
            "12/22<div id=\"image_11\"><img src=\"http://1.bp.blogspot" +
            ".com/-UZp15SAOezU/VuLnJ8MRwYI/AAAAAAAM_H4/W6HFbGpQ_jw/s0/bt4142-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-10.png?imgmax=0\" class=\"lazy\" id=\"img11\"></div><br>Trang 13/22<div id=\"image_12\"><img " +
            "src=\"http://1.bp.blogspot.com/-NB2chZr2-mI/VuLnLpPXGLI/AAAAAAAM_H8/Rpevz0gbDkM/s0/bt4149" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-11.png?imgmax=0\" class=\"lazy\" id=\"img12\"></div><br>Trang " +
            "14/22<div id=\"image_13\"><img src=\"http://1.bp.blogspot" +
            ".com/-v3ReCaKhajU/VuLnNRmBy4I/AAAAAAAM_IA/8b4b8pQ-neU/s0/bt4156-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-12.png?imgmax=0\" class=\"lazy\" id=\"img13\"></div><br>Trang 15/22<div id=\"image_14\"><img " +
            "src=\"http://1.bp.blogspot.com/-RYq-PfrGiYo/VuLnO2H1miI/AAAAAAAM_IE/x41y0B6MDjU/s0/bt4202" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-13.png?imgmax=0\" class=\"lazy\" id=\"img14\"></div><br>Trang " +
            "16/22<div id=\"image_15\"><img src=\"http://1.bp.blogspot" +
            ".com/-UD6cLsIauxg/VuLnQjKfAVI/AAAAAAAM_II/T5MAE0u1kEw/s0/bt4209-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-14.png?imgmax=0\" class=\"lazy\" id=\"img15\"></div><br>Trang 17/22<div id=\"image_16\"><img " +
            "src=\"http://1.bp.blogspot.com/-P9getiQTEx8/VuLnSTcL0sI/AAAAAAAM_IM/QJmVA45AQSw/s0/bt4216" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-15.png?imgmax=0\" class=\"lazy\" id=\"img16\"></div><br>Trang " +
            "18/22<div id=\"image_17\"><img src=\"http://1.bp.blogspot" +
            ".com/-_l9nbuFo4E4/VuLnTz-kgdI/AAAAAAAM_IQ/M721e-V9bN0/s0/bt4223-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-16.png?imgmax=0\" class=\"lazy\" id=\"img17\"></div><br>Trang 19/22<div id=\"image_18\"><img " +
            "src=\"http://1.bp.blogspot.com/-soJWnlpLqCY/VuLnVp3aqCI/AAAAAAAM_IU/b0tmyxW5HL8/s0/bt4229" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-17.png?imgmax=0\" class=\"lazy\" id=\"img18\"></div><br>Trang " +
            "20/22<div id=\"image_19\"><img src=\"http://1.bp.blogspot" +
            ".com/-2hlnBAD9pDg/VuLnXhBLWII/AAAAAAAM_Ic/QGvjD7NDp0s/s0/bt4237-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-18.png?imgmax=0\" class=\"lazy\" id=\"img19\"></div><br>Trang 21/22<div id=\"image_20\"><img " +
            "src=\"http://1.bp.blogspot.com/-ZuvoOUclSf8/VuLnZlXOkYI/AAAAAAAM_Ig/htRKZ7_sLPs/s0/bt4244" +
            "-BungakuShoujotoShiniTagarinoDoukev03c17-19.png?imgmax=0\" class=\"lazy\" id=\"img20\"></div><br>Trang " +
            "22/22<div id=\"image_21\"><img src=\"http://1.bp.blogspot" +
            ".com/-V8jAXbtDdIk/VuLnbUkscSI/AAAAAAAM_Ik/47wlbQacsKs/s0/bt4252-BungakuShoujotoShiniTagarinoDoukev03c17" +
            "-20.png?imgmax=0\" class=\"lazy\" id=\"img21\"></div></div><script type=\"text/javascript\">\n";

    public static void main(String[] args) {
        TruyenTranh8 tt8 = new TruyenTranh8();
        System.out.println(tt8.getChapterImageList(debugHTML));
    }
}
