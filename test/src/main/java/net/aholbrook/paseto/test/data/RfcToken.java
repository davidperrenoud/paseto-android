/*
Copyright 2018 Andrew Holbrook

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package net.aholbrook.paseto.test.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.aholbrook.paseto.service.Token;

import java.time.OffsetDateTime;
import java.util.Objects;

// only needed for testing as we store the result as a string, so the field order must match
@JsonPropertyOrder({"data", "exp"})
public class RfcToken extends Token {
	private String data;

	public RfcToken() {
	}

	public RfcToken(String data, String exp) {
		this.data = data;
		setExpiration(Token.DATETIME_FORMATTER.parse(exp, OffsetDateTime::from));
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		RfcToken rfcToken = (RfcToken) o;
		return Objects.equals(data, rfcToken.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), data);
	}
}
