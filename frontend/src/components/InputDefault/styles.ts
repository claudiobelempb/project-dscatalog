import styled, { css } from 'styled-components';

export const InputContainer = styled.div`
  position: relative;
`;

export const InputDefaultContainer = styled.input`
  ${({ theme }) => css`
    position: relative;
    display: flex;
    align-items: center;
    width: 100%;
    height: 100%;
    padding-right: 2.5rem;
    padding-left: 1rem;
    padding-top: 0.5rem;
    padding-bottom: 0.5rem;
    border: 3px solid transparent;

    color: ${theme.colors.black_100};
    border-radius: 0.5rem;
    -webkit-border-radius: 0.5rem;
    -moz-border-radius: 0.5rem;
    font-size: 1rem;
    background: ${theme.colors.white_100};
    */ @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const InputDefaultSmall = styled(InputDefaultContainer)`
  ${({ theme }) => css`
    /* background: ${theme.colors.white_100}; */
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const InputIconDefault = styled.button`
  ${({ theme }) => css`
    position: absolute;
    top: 0;
    bottom: 0;
    right: 13px;
    background-color: transparent;
    color: ${theme.colors.white_100};

    & svg {
      color: ${theme.colors.blue_100};
      width: 1.3rem;
      height: 1.3rem;
    }

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
