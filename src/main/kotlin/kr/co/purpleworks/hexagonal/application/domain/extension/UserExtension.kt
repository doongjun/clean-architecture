package kr.co.purpleworks.hexagonal.application.domain.extension

import java.util.concurrent.ThreadLocalRandom

fun getCurrentUserId() = ThreadLocalRandom.current().nextInt().toLong()