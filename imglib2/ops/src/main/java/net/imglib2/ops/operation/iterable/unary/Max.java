package net.imglib2.ops.operation.iterable.unary;

import java.util.Iterator;

import net.imglib2.ops.operation.UnaryOperation;
import net.imglib2.type.numeric.RealType;

public class Max< T extends RealType< T >, V extends RealType< V >> implements UnaryOperation< Iterator< T >, V >
{

	@Override
	public V compute( Iterator< T > input, V output )
	{
		double max = -Double.MAX_VALUE;
		while ( input.hasNext() )
		{
			T in = input.next();

			double val = in.getRealDouble();
			if ( val > max )
				max = val;
		}

		output.setReal( max );
		return output;
	}

	@Override
	public UnaryOperation< Iterator< T >, V > copy()
	{
		return new Max< T, V >();
	}

}
