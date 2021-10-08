package sheridan.alihamz.assignment1.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import sheridan.alihamz.assignment1.R
import sheridan.alihamz.assignment1.Util.Utils
import sheridan.alihamz.assignment1.databinding.FragmentOutputBinding

class OutputFragment : Fragment() {

    private var _binding: FragmentOutputBinding? = null
    private val binding get() = _binding!!


    private var userInput: Int? = 0
    private var isUserWin: Boolean? = false


    companion object {
        fun newInstance(userInput: Int): Fragment {
            val fragment = OutputFragment()
            val args = Bundle()
            args.putInt("userInput", userInput)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOutputBinding.inflate(inflater, container, false)
        val view = binding.root
        userInput = arguments?.getInt("userInput", 0)

        binding.btnPlayAgain.setOnClickListener(View.OnClickListener {
            requireActivity().onBackPressed()
        })
        init()

        return view
    }

    private fun init() {
        binding.tvUser.text = getSelection(userInput);
        /**get random selection from computer*/
        val computer_input = (1..3).random()
        binding.tvComputer.text = getSelection(computer_input)

        if (userInput == computer_input) {
            /** for same input match is DRAW*/
            binding.tvWinner.text = resources.getString(R.string.lbl_draw)
            binding.tvWinner.setTextColor(ContextCompat.getColor(requireActivity(), R.color.grey_dark))

        } else {
            Log.e("WW","$userInput : $computer_input")
            if (userInput == Utils.PAPER) {
                /**Paper wrap Rock*/
                if (computer_input == Utils.ROCK) {
                    isUserWin = true;
                } else if (computer_input == Utils.SCISSORS) {
                    isUserWin = false;
                }
            } else if (userInput == Utils.ROCK) {
                /**Rock blunts Scissors*/
                if (computer_input == Utils.SCISSORS) {
                    isUserWin = true;
                } else if (computer_input == Utils.PAPER) {
                    isUserWin = false;
                }
            } else if (userInput == Utils.SCISSORS) {
                /**Scissors cuts paper */
                if (computer_input == Utils.PAPER) {
                    isUserWin = true;
                } else if (computer_input == Utils.ROCK) {
                    isUserWin = false;
                }
            }

            if (isUserWin!!) {
                binding.tvWinner.text = resources.getString(R.string.lbl_user)
                binding.tvWinner.setTextColor(ContextCompat.getColor(requireActivity(), R.color.green))

            } else {
                binding.tvWinner.text = resources.getString(R.string.lbl_computer)
                binding.tvWinner.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))


            }
        }
    }

    private fun getSelection(inputValue: Int?): CharSequence? {
        /** Fetch the string value from its index position
         * for display in screen */

        if (inputValue == Utils.PAPER) {
            return resources.getString(R.string.lbl_paper)
        } else if (inputValue == Utils.ROCK) {
            return resources.getString(R.string.lbl_rock)
        } else {
            return resources.getString(R.string.lbl_scissors)
        }
    }


}