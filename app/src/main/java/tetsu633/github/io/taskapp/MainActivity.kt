package tetsu633.github.io.taskapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var array: ArrayList<String> = arrayListOf("test", "test1", "test2")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, array)
        listView.adapter = adapter
        listView.onItemClickListener = OnItemClickListener()
    }

    inner class OnItemClickListener: AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val intent = Intent(this@MainActivity, NewForm::class.java)
            intent.putExtra("text", (view.findViewById<TextView>(android.R.id.text1)).text)
            startActivity(intent)
        }
    }
}

