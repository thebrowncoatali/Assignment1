package sheridan.alihamz.assignment1.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import sheridan.alihamz.assignment1.R
import sheridan.alihamz.assignment1.Util.Utils
import sheridan.alihamz.assignment1.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {
        fun newInstance(): Fragment {
            val fragment = InputFragment()
            val args = Bundle()

            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val view = binding.root

        binding.btnPlay.setOnClickListener(View.OnClickListener {

            var index: Int = 0;
            if (binding.rbPaper.isChecked) {
                index = Utils.PAPER
            } else if (binding.rbRock.isChecked) {
                index = Utils.ROCK
            } else if (binding.rbScissors.isChecked) {
                index = Utils.SCISSORS
            } else {
                Toast.makeText(
                    activity,
                    resources.getString(R.string.msg_select_your_choice),
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }

            var fragment: Fragment = OutputFragment.newInstance(index)
            val tr = requireActivity().supportFragmentManager.beginTransaction()
            tr.replace(
                sheridan.alihamz.assignment1.R.id.frameHome,
                fragment,
                fragment.javaClass.simpleName
            )
            tr.addToBackStack(fragment.javaClass.simpleName)
            tr.commit()
        })
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

