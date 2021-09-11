package com.giftech.academy.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.giftech.academy.data.source.local.entity.ModuleEntity

data class CourseWithModule (
    @Embedded
    var mCourse: CourseEntity,

    @Relation(parentColumn = "courseId", entityColumn = "courseId")
    var mModules: List<ModuleEntity>
)