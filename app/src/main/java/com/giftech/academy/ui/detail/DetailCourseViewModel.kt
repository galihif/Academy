package com.giftech.academy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.academy.data.CourseEntity
import com.giftech.academy.data.ModuleEntity
import com.giftech.academy.data.source.AcademyRepository

class DetailCourseViewModel(private val academyRepository: AcademyRepository):ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): LiveData<CourseEntity> = academyRepository.getCourseWithModules(courseId)

    fun getModules(): LiveData<List<ModuleEntity> > = academyRepository.getAllModulesByCourse(courseId)

}