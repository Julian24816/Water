package dev.julianm.water

import java.time.Instant

data class Water(val id: Int, val ml: Int, val time: Instant = Instant.now());
