package com.giftech.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.giftech.academy.R
import com.giftech.academy.data.CourseEntity
import com.giftech.academy.databinding.ActivityDetailCourseBinding
import com.giftech.academy.databinding.ContentDetailCourseBinding
import com.giftech.academy.ui.reader.CourseReaderActivity
import com.giftech.academy.viewmodel.ViewModelFactory

class DetailCourseActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var detailContentBinding: ContentDetailCourseBinding
    private lateinit var activityDetailCourseBinding:ActivityDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val adapter = DetailCourseAdapter()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCourseViewModel::class.java]

        val extras = intent.extras
        if(extras != null){

            activityDetailCourseBinding.progressBar.visibility = View.VISIBLE
            activityDetailCourseBinding.containerDetailContent.visibility = View.INVISIBLE

            val courseId = extras.getString(EXTRA_COURSE)
            if(courseId != null){
                viewModel.setSelectedCourse(courseId)
                viewModel.getModules().observe(this, {modules ->
                    activityDetailCourseBinding.progressBar.visibility = View.GONE
                    activityDetailCourseBinding.containerDetailContent.visibility = View.VISIBLE

                    adapter.setModules(modules)
                    adapter.notifyDataSetChanged()
                })

                viewModel.getCourse().observe(this, { course -> populateCourse(course) })
            }
        }

        with(detailContentBinding.rvModule){
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        with(detailContentBinding){
            textTitle.text = courseEntity.title
            textDescription.text = courseEntity.description
            textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

            Glide.with(this@DetailCourseActivity)
                .load(courseEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(imagePoster)

            btnStart.setOnClickListener {
                val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
                intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
                startActivity(intent)
            }
        }
    }
}