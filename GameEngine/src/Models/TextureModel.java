package Models;

import textures.ModelTexture;

public class TextureModel {
	private rawModel rawmodel;
	private ModelTexture texture;
	public TextureModel(rawModel model,ModelTexture texture)
	{
	 this.rawmodel = model;
	 this.texture = texture;
	}
	public rawModel getRawmodel() {
		return rawmodel;
	}
	public ModelTexture getTexture() {
		return texture;
	}

}
