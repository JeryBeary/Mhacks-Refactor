package baitsbait.heart2heart;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.Token;

public class FitbitApi extends DefaultApi10a
{
  private static final String AUTHORIZE_URL = "https://www.fitbit.com/oauth/authorize?token=%s";

  @Override
  public String getAccessTokenEndpoint()
  {
    return "https://api.fitbit.com/oauth/access_token";
  }

  @Override
  public String getRequestTokenEndpoint()
  {
    return "https://api.fitbit.com/oauth/request_token";
  }

  @Override
  public String getAuthorizationUrl(Token requestToken)
  {
    return String.format(AUTHORIZE_URL, requestToken.getToken());
  }

}