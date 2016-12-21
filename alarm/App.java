package alarm

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;

public class App implements Speechlet{

	@Override
	public SpeechletResponse onIntent(final IntentRequest request, final Session session) throws SpeechletException {

		Intent intent = request.getIntent();

		String intentName = (intent != null) ? intent.getName() : null;

		if("SetAlarm".equals(intentName)){
			return setAlarm();
		}else{
			throw new SpeechletException("Invalid intent");
		}
	}

	@Override
	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {

	}

	@Override
	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {


	}

	@Override
	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {

	}

	private SpeechletReponse setAlarm(){
		/*
			Code to send to the Alexa service setting the alarm.
			Returns a plain text response confirming the alarm
			is set or not.
		*/
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText("Set alarm!");
		return new SpeechletResponse.newTellResponse(speech);
		 
	}


}