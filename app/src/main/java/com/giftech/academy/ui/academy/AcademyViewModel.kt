package com.giftech.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.giftech.academy.data.CourseEntity
import com.giftech.academy.data.source.AcademyRepository
import com.giftech.academy.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository):ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()

}