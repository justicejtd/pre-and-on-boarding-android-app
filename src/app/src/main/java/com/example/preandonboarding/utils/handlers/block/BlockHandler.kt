package com.example.preandonboarding.utils.handlers.block

import com.example.preandonboarding.data.model.block.BaseBlock

class BlockHandler(private val blocks: List<BaseBlock>) {

    fun getStartingBlock(): BaseBlock? {
        return blocks.singleOrNull { it.isStartBlock }
    }

    fun getBlockById(blockId: Int): BaseBlock? {
        var block: BaseBlock? = null

        if (blockId > 0) {
            block = blocks.singleOrNull { it.id == blockId }
        }
        return block
    }
}