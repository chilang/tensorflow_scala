/* Copyright 2017, Emmanouil Antonios Platanios. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.platanios.tensorflow.api.ops.rnn

/**
  * @author Emmanouil Antonios Platanios
  */
package object decoder {
  private[rnn] trait API {
    type RNNDecoder[O, OS, S, SS, DO, DOS, DS, DSS, DFO, DFS] = decoder.RNNDecoder[O, OS, S, SS, DO, DOS, DS, DSS, DFO, DFS]
    type BasicRNNDecoder[O, OS, S, SS] = decoder.BasicRNNDecoder[O, OS, S, SS]
    type BeamSearchRNNDecoder[S, SS] = decoder.BeamSearchRNNDecoder[S, SS]

    val BasicRNNDecoder: decoder.BasicRNNDecoder.type = decoder.BasicRNNDecoder
    val BeamSearchRNNDecoder: decoder.BeamSearchRNNDecoder.type = decoder.BeamSearchRNNDecoder

    def beamSearchRNNDecoderTileBatch[T: BeamSearchRNNDecoder.Supported](value: T, multiplier: Int): T = {
      implicitly[BeamSearchRNNDecoder.Supported[T]].tileBatch(value, multiplier)
    }
  }
}
