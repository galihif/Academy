package com.giftech.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.giftech.academy.data.CourseEntity
import com.giftech.academy.utils.DataDummy

class AcademyViewModel:ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()

}