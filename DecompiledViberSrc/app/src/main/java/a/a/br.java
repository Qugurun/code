package a.a;

import org.json.JSONObject;

public class br extends bp
{
  private br(gs paramgs, JSONObject paramJSONObject)
  {
    super(paramgs, paramJSONObject);
  }

  public static br j(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cid", paramString);
    return new br(gs.e, localJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.br
 * JD-Core Version:    0.6.2
 */