/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.models;

import org.apache.wicket.model.IModel;

public class AddressModel implements IModel
{

	private IModel addressContainingModel;

	private AddressModelType type;

	public enum AddressModelType {
		CITY_MODEL;
	};

	public AddressModel(IModel addressContainingModel, AddressModelType type)
	{
		this.addressContainingModel = addressContainingModel;
		this.type = type;
	}

	@Override
	public Object getObject()
	{

		Address address = (Address)addressContainingModel.getObject();

		switch (type)
		{

			case CITY_MODEL :

				return address.getCity();
		}

		throw new UnsupportedOperationException("invalid AddressModelType = " + type.name());
	}

	@Override
	public void setObject(Object object)
	{

		Address address = (Address)addressContainingModel.getObject();

		switch (type)
		{

			case CITY_MODEL :

				address.setCity((String)object);
				break;
			default :
				throw new UnsupportedOperationException(
					"invalid AddressModelType = " + type.name());
		}

	}

	@Override
	public void detach()
	{

		addressContainingModel.detach();

	}

}
