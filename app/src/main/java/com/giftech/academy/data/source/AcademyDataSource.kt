package com.giftech.academy.data.source

import com.giftech.academy.data.CourseEntity
import com.giftech.academy.data.ModuleEntity

interface AcademyDataSource{

    fun getAllCourses(): List<CourseEntity>

    fun getBookmarkedCourses(): List<CourseEntity>

    fun getCourseWithModules(courseId: String): CourseEntity

    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>

    fun getContent(courseId: String, moduleId: String): ModuleEntity
}