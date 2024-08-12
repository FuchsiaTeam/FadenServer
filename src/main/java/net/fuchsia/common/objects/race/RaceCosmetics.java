package net.fuchsia.common.objects.race;

import net.fuchsia.common.race.cosmetic.RaceCosmeticPalette;
import net.fuchsia.common.race.cosmetic.RaceCosmeticSlot;

public class RaceCosmetics {

    public static RaceCosmeticPalette HARENGON = new RaceCosmeticPalette();
    public static RaceCosmeticPalette ELF = new RaceCosmeticPalette();
    public static RaceCosmeticPalette TABAXI = new RaceCosmeticPalette();

    public static void add() {
        /*
        * HARENGON
        * */
        //EAR
        HARENGON.addCosmetic("brown", "faden:player_cosmetic/harengon/ears/harengon_ears_brown", RaceCosmeticSlot.HEAD, "ear_0");
        HARENGON.addCosmetic("brown", "faden:player_cosmetic/harengon/ears/floppy/harengon_ears_floopy_brown", RaceCosmeticSlot.HEAD, "ear_1");

        HARENGON.addCosmetic("black", "faden:player_cosmetic/harengon/ears/harengon_ears_black", RaceCosmeticSlot.HEAD, "ear_0");
        HARENGON.addCosmetic("black", "faden:player_cosmetic/harengon/ears/floppy/harengon_ears_floopy_black", RaceCosmeticSlot.HEAD, "ear_1");

        HARENGON.addCosmetic("gold", "faden:player_cosmetic/harengon/ears/harengon_ears_gold", RaceCosmeticSlot.HEAD, "ear_0");
        HARENGON.addCosmetic("gold", "faden:player_cosmetic/harengon/ears/floppy/harengon_ears_floopy_gold", RaceCosmeticSlot.HEAD, "ear_1");

        HARENGON.addCosmetic("salt", "faden:player_cosmetic/harengon/ears/harengon_ears_salt", RaceCosmeticSlot.HEAD, "ear_0");
        HARENGON.addCosmetic("salt", "faden:player_cosmetic/harengon/ears/floppy/harengon_ears_floopy_salt", RaceCosmeticSlot.HEAD, "ear_1");

        HARENGON.addCosmetic("toast", "faden:player_cosmetic/harengon/ears/harengon_ears_toast", RaceCosmeticSlot.HEAD, "ear_0");
        HARENGON.addCosmetic("toast", "faden:player_cosmetic/harengon/ears/floppy/harengon_ears_floopy_toast", RaceCosmeticSlot.HEAD, "ear_1");

        HARENGON.addCosmetic("white", "faden:player_cosmetic/harengon/ears/harengon_ears_white", RaceCosmeticSlot.HEAD, "ear_0");
        HARENGON.addCosmetic("white", "faden:player_cosmetic/harengon/ears/floppy/harengon_ears_floopy_white", RaceCosmeticSlot.HEAD, "ear_1");

        HARENGON.addCosmetic("white_splotched", "faden:player_cosmetic/harengon/ears/harengon_ears_white_splotched", RaceCosmeticSlot.HEAD, "ear_0");
        HARENGON.addCosmetic("white_splotched", "faden:player_cosmetic/harengon/ears/floppy/harengon_ears_floopy_white_splotched", RaceCosmeticSlot.HEAD, "ear_1");

        //TAIL
        HARENGON.addCosmetic("brown", "faden:player_cosmetic/harengon/tail/harengon_tail_brown", RaceCosmeticSlot.CHEST, "tail_0");
        HARENGON.addCosmetic("black", "faden:player_cosmetic/harengon/tail/harengon_tail_black", RaceCosmeticSlot.CHEST, "tail_0");
        HARENGON.addCosmetic("gold", "faden:player_cosmetic/harengon/tail/harengon_tail_gold", RaceCosmeticSlot.CHEST, "tail_0");
        HARENGON.addCosmetic("salt", "faden:player_cosmetic/harengon/tail/harengon_tail_salt", RaceCosmeticSlot.CHEST, "tail_0");
        HARENGON.addCosmetic("toast", "faden:player_cosmetic/harengon/tail/harengon_tail_toast", RaceCosmeticSlot.CHEST, "tail_0");
        HARENGON.addCosmetic("white", "faden:player_cosmetic/harengon/tail/harengon_tail_white", RaceCosmeticSlot.CHEST, "tail_0");
        HARENGON.addCosmetic("white_splotched", "faden:player_cosmetic/harengon/tail/harengon_tail_white_splotched", RaceCosmeticSlot.CHEST, "tail_0");

        /*
        * ELF
        * */
        //EAR
        ELF.addCosmetic("pale", "faden:player_cosmetic/elf/ears/elf_ears_0_pale", RaceCosmeticSlot.HEAD, "ear_0");
        ELF.addCosmetic("pale", "faden:player_cosmetic/elf/ears/elf_ears_1_pale", RaceCosmeticSlot.HEAD, "ear_1");
        ELF.addCosmetic("pale", "faden:player_cosmetic/elf/ears/elf_ears_2_pale", RaceCosmeticSlot.HEAD, "ear_2");
        ELF.addCosmetic("pale", "faden:player_cosmetic/elf/ears/elf_ears_3_pale", RaceCosmeticSlot.HEAD, "ear_3");
        ELF.addCosmetic("pale", "faden:player_cosmetic/elf/ears/elf_ears_4_pale", RaceCosmeticSlot.HEAD, "ear_4");

        ELF.addCosmetic("drow", "faden:player_cosmetic/elf/ears/elf_ears_0_drow", RaceCosmeticSlot.HEAD, "ear_0");
        ELF.addCosmetic("drow", "faden:player_cosmetic/elf/ears/elf_ears_1_drow", RaceCosmeticSlot.HEAD, "ear_1");
        ELF.addCosmetic("drow", "faden:player_cosmetic/elf/ears/elf_ears_2_drow", RaceCosmeticSlot.HEAD, "ear_2");
        ELF.addCosmetic("drow", "faden:player_cosmetic/elf/ears/elf_ears_3_drow", RaceCosmeticSlot.HEAD, "ear_3");
        ELF.addCosmetic("drow", "faden:player_cosmetic/elf/ears/elf_ears_4_drow", RaceCosmeticSlot.HEAD, "ear_4");


        /*
        * TABAXI
         */
        TABAXI.addCosmetic("black", "todo", RaceCosmeticSlot.HEAD, "ear", "ear_0");
        TABAXI.addCosmetic("black", "todo", RaceCosmeticSlot.HEAD, "mouth", "mouth_0");

    }

}
