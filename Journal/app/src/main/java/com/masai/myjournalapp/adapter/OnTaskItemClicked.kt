package com.masai.myjournalapp.adapter

import com.masai.myjournalapp.RoutineModel

interface OnTaskItemClicked {
    fun onEditClicked(routine: RoutineModel)
    fun onDeleteClicked(routine: RoutineModel)
}