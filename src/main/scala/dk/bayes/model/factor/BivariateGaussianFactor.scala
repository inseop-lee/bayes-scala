package dk.bayes.model.factor

import dk.bayes.math.gaussian.Linear._
import dk.bayes.math.gaussian.CanonicalGaussian
import dk.bayes.model.factor.api.DoubleFactor
import dk.bayes.model.factor.api.Factor
import dk.bayes.model.factor.api.SingleFactor

/**
 * This class represents bivariate Gaussian Factor.
 *
 * @author Daniel Korzekwa
 */
case class BivariateGaussianFactor(parentVarId: Int, varId: Int, mean: Matrix, variance: Matrix) extends DoubleFactor {

  def getVariableIds(): Seq[Int] = Vector(parentVarId, varId)

  def marginal(varId: Int): SingleFactor = throw new UnsupportedOperationException("Not implemented yet")

  def outgoingMessages(factor1: Factor, factor2: Factor): Tuple2[SingleFactor, SingleFactor] = throw new UnsupportedOperationException("Not implemented yet")

  override def *(factor: Factor): BivariateGaussianFactor = {
    factor match {
      case factor: GaussianFactor => {
        val gaussianFactor = factor.asInstanceOf[GaussianFactor]
        require(gaussianFactor.varId == parentVarId || gaussianFactor.varId == varId, "Incorrect gaussian variable id.")

        val canonGaussian = CanonicalGaussian(mean, variance)

        val extendedGaussianFactor = if (gaussianFactor.varId == parentVarId) CanonicalGaussian(gaussianFactor.m, gaussianFactor.v).extend(2, 0)
        else CanonicalGaussian(gaussianFactor.m, gaussianFactor.v).extend(2, 1)
        
        val productGaussian = canonGaussian * extendedGaussianFactor
        val bivariateGaussianFactor = BivariateGaussianFactor(parentVarId, varId, productGaussian.mean(), productGaussian.variance())
        bivariateGaussianFactor
      }
      case _ => throw new IllegalArgumentException("BivariateGaussian factor cannot be multiplied by a factor that is non gaussian")
    }
  }

}